package com.app.lee.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;

import com.app.lee.utils.MPermissionUtils;

/**
 * Created by lichen on 2018/1/4.
 */

public abstract class BaseActivity<P extends BasePresenter, B extends ViewDataBinding> extends AppCompatActivity {

    public Context mContext;
    public B mViewBinding;
    public P mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = getLayoutInflater().inflate(this.getLayoutId(), null, false);
        mViewBinding = DataBindingUtil.bind(rootView);
        setContentView(rootView);
        mContext = this;
        initView();
    }

    public abstract int getLayoutId();

    public abstract void initView();

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        MPermissionUtils.onRequestPermissionsResult(requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) mPresenter.onDetached();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
                finish();
                return true;
            } else {
                try {
                    getSupportFragmentManager().popBackStackImmediate();
                } catch (Exception e) {
                }
                return true;
            }
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}
