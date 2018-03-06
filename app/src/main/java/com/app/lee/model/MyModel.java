package com.app.lee.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lichen on 2018/1/16.
 */

public class MyModel implements Parcelable {
    protected MyModel(Parcel in) {
    }

    public static final Creator<MyModel> CREATOR = new Creator<MyModel>() {
        @Override
        public MyModel createFromParcel(Parcel in) {
            return new MyModel(in);
        }

        @Override
        public MyModel[] newArray(int size) {
            return new MyModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
