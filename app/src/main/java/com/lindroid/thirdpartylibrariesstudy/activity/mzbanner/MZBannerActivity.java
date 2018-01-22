package com.lindroid.thirdpartylibrariesstudy.activity.mzbanner;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.lindroid.thirdpartylibrariesstudy.R;
import com.lindroid.thirdpartylibrariesstudy.util.status.StatusBarHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author linyulong
 */
public class MZBannerActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapse_toolbar)
    CollapsingToolbarLayout collapseToolbar;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.textView2)
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mzbanner);
        ButterKnife.bind(this);
        StatusBarHelper.setStatusBarLightMode(this);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(true);
        }

        Typeface font = Typeface.create("sans-serif-light", Typeface.BOLD);
        collapseToolbar.setExpandedTitleTypeface(font);
        textView2.setTypeface(font);


//        View titleView = toolbar.getChildAt(0);
//        titleView.getId();
//        Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams
//                (Toolbar.LayoutParams.WRAP_CONTENT,
//                        Toolbar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
//        titleView.setLayoutParams(layoutParams);

    }
}
