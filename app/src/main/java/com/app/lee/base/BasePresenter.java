package com.app.lee.base;

import org.greenrobot.eventbus.EventBus;

import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by lichen on 2018/1/4.
 */

public abstract class BasePresenter<V> {

    protected V mView;
    protected CompositeDisposable mCompositeSubscription = new CompositeDisposable();

    public BasePresenter(V v) {
        this.mView = v;
        this.onAttached();
        onStart();
    }

    public abstract void onAttached();

    public void onDetached() {
        mCompositeSubscription.dispose();
        if (useEventBus())//如果要使用eventbus请将此方法返回true
            EventBus.getDefault().unregister(this);//解除注册eventbus
        this.mView = null;
    }

    public void onStart() {
        if (useEventBus())//如果要使用eventbus请将此方法返回true
            EventBus.getDefault().register(this);//注册eventbus
    }

    protected boolean useEventBus() {
        return false;
    }
}
