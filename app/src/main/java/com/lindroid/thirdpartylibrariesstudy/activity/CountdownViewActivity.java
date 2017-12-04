package com.lindroid.thirdpartylibrariesstudy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lindroid.thirdpartylibrariesstudy.R;

import cn.iwgang.countdownview.CountdownView;

/**
 * @author linyulong
 */
public class CountdownViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown_view);
        CountdownView mCvCountdownView = (CountdownView) findViewById(R.id.countdownView);
        //毫秒
        mCvCountdownView.start(995550000);
    }
}
