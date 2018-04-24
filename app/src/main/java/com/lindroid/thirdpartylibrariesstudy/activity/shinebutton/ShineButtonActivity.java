package com.lindroid.thirdpartylibrariesstudy.activity.shinebutton;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.lindroid.thirdpartylibrariesstudy.R;
import com.sackcentury.shinebuttonlib.ShineButton;

/**
 * @author linyulong
 * @date 2018/04/24
 */
public class ShineButtonActivity extends AppCompatActivity {

    private final String TAG = "shineBtn";
    private ShineButton shineBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shine_button);
        initView();
    }

    private void initView() {
        shineBtn = (ShineButton) findViewById(R.id.shine_btn);
        //enableFlashing属性只决定动画是否闪烁抖动，影响不大
        shineBtn.enableFlashing(true);
        shineBtn.setOnCheckStateChangeListener(new ShineButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(View view, boolean b) {
                Log.e(TAG, "选中状态：" + b);
                if (b) {
                    shineBtn.setBtnFillColor(ContextCompat.getColor(ShineButtonActivity.this,
                            android.R.color.holo_red_light));
                    shineBtn.setBtnFillColor(ContextCompat.getColor(ShineButtonActivity.this,
                            android.R.color.darker_gray));
                } else {
                    shineBtn.setBtnFillColor(ContextCompat.getColor(ShineButtonActivity.this,
                            android.R.color.darker_gray));
                }
            }
        });
    }
}
