package com.app.lee.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.app.lee.R;
import com.app.lee.base.RoutePath;

/**
 * Created by lichen on 2018/1/9.
 */
@Route(path = RoutePath.TEST)
public class TestActivity extends AppCompatActivity {

    @Autowired
    String name = "jack";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        TextView textView = findViewById(R.id.text);
//        String name = getIntent().getStringExtra("name");
        ARouter.getInstance().inject(this);
        textView.setText(name);
    }
}
