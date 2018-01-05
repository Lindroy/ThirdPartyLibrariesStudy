package com.lindroid.thirdpartylibrariesstudy.activity.simplebehavior;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.lindroid.thirdpartylibrariesstudy.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author linyulong
 */
public class SimpleBehaviorActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapse_toolbar)
    CollapsingToolbarLayout collapseToolbar;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_behaviorctivity);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

//        collapseToolbar.setStatusBarScrimColor(ContextCompat.getColor(this,android.R.color.holo_red_light));


    }

    @OnClick(R.id.iv_avatar)
    public void onViewClicked() {
        startActivity(new Intent(SimpleBehaviorActivity.this, EleShopDetailActivity.class));
    }
}
