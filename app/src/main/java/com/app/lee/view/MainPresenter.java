package com.app.lee.view;

import com.app.lee.api.Api;
import com.app.lee.api.http.RxSchedulers;

import org.reactivestreams.Subscriber;

/**
 * Created by lichen on 2018/1/4.
 */

public class MainPresenter extends MainContract.Presenter {


    public MainPresenter(MainContract.View view) {
        super(view);
    }

    @Override
    public void loadData() {
        mCompositeSubscription.add(
                Api.getInstance().service.login("member-login", "memberLogin", "1.0.0", "{\"ipAdd\":\"10.55.65.130\",\"loginName\":\"13585269669\",\"loginPwd\":\"9a84ee41aa72de59c63006aad670bcce\",\"memberId\":\"1201711202005435890220860671\",\"registerSource\":\"102\",\"terminalId\":\"865383039836972\"}", "29238923i2", "11")
                        .compose(RxSchedulers.io_main())
                        .subscribe(
                                res -> mView.showData(res.retDesc),
                                e -> mView.showData(e.getMessage())
                        )
        );
    }

    @Override
    protected boolean useEventBus() {
        return super.useEventBus();
    }
}
