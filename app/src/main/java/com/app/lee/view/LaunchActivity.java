package com.app.lee.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;
import com.app.lee.R;
import com.app.lee.base.RoutePath;
import com.app.lee.model.eventtype.AnyEventType;
import com.app.lee.utils.RxTimerUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;


/**
 * Created by lichen on 2018/1/12.
 */

public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        EventBus.getDefault().register(this);
        initView();
    }

    private void initView() {

        RxTimerUtil.timer(2000, number -> {
//            ARouter.getInstance().build(RoutePath.MAIN).navigation(this);
//            finish();
            EventBus.getDefault().post("jump");
        });


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        RxTimerUtil.cancel();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(String s) {
        if ("jump".equals(s))
        ARouter.getInstance().build(RoutePath.MAIN).navigation(this);
//        finish();
    }
}
