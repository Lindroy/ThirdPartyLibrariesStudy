package com.lindroid.thirdpartylibrariesstudy.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.lindroid.thirdpartylibrariesstudy.R;

import cn.albert.autosystembar.SystemBarHelper;

/**
 * @author linyulong
 */
public class AutoSystemBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_system_bar);

        SystemBarHelper helper = new SystemBarHelper.Builder().into(this);
        helper.setNavigationBarColor(ContextCompat.getColor(this, android.R.color.holo_orange_light));
        helper.setStatusBarColor(ContextCompat.getColor(this, android.R.color.holo_blue_light));
        helper.statusBarFontStyle(ContextCompat.getColor(this, android.R.color.holo_green_light));
        helper.enableImmersedStatusBar(false);
        helper.enableImmersedNavigationBar(false);
    }
}
