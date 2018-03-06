package com.app.lee.view;

import com.app.lee.base.BasePresenter;
import com.app.lee.base.BaseView;

/**
 * Created by lichen on 2018/1/4.
 */

public interface MainContract {

    interface View extends BaseView {

        void showData(String s);
    }

    abstract class Presenter extends BasePresenter<View> {

        public Presenter(View view) {
            super(view);
        }

        public abstract void loadData();

        @Override
        public void onAttached() {
        }
    }
}
