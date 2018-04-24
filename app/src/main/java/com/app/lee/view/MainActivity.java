package com.app.lee.view;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.app.lee.R;
import com.app.lee.aop.CheckLogin;
import com.app.lee.base.BaseActivity;
import com.app.lee.base.Constants;
import com.app.lee.base.RoutePath;
import com.app.lee.databinding.ActivityMainBinding;
import com.app.lee.utils.LogUtils;

/**
 * Created by lichen on 2018/1/4.
 */
@Route(path = RoutePath.MAIN)
public class MainActivity extends BaseActivity<MainPresenter, ActivityMainBinding> implements MainContract.View {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mPresenter = new MainPresenter(this);
        mPresenter.loadData();
        mViewBinding.show.setOnClickListener(view -> {
            ARouter.getInstance()
                    .build("/app/activity/test")
                    .withString("name", "test")
                    .navigation(this);
        });
        mViewBinding.browser.setOnClickListener(view -> {
                    ARouter.getInstance()
                            .build(RoutePath.BROWSERACTIVITY)
                            .withString("url", "http://mc.vip.qq.com/demo/indexv3")
                            .withInt("mode", Constants.MODE_SONIC)
                            .navigation(this);
                    LogUtils.e("browser-start");
                }
        );
        mViewBinding.browserDef.setOnClickListener(view -> {
//                    ARouter.getInstance()
//                            .build(RoutePath.BROWSERACTIVITY)
//                            .withString("url", "http://mc.vip.qq.com/demo/indexv3")
//                            .withInt("mode", Constants.MODE_DEFAULT)
//                            .navigation(this);
//                    LogUtils.e("browserDef-start");
                    test(view);
                }
        );
    }

    @CheckLogin
    public void test(View view) {
        LogUtils.e("Hello, I am CSDN_LQR");
    }


    @Override
    public void showData(String s) {
        mViewBinding.show.setText(s);
    }
}
