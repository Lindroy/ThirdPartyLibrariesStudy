package com.lindroid.thirdpartylibrariesstudy.activity.mzbanner;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lindroid.thirdpartylibrariesstudy.R;
import com.lindroid.thirdpartylibrariesstudy.util.status.StatusBarHelper;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

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
    @BindView(R.id.banner)
    MZBannerView banner;

    private List<Integer> imageList = new ArrayList<>();
    private ImageView ivBanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mzbanner);
        ButterKnife.bind(this);
        initData();
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

        initBanner();

    }

    private void initBanner() {
        //设置指示器的代码应该在setPages前面
        banner.setIndicatorRes(R.drawable.shape_indicator_unselected, R.drawable.shape_indicator_selected);
        banner.setPages(imageList, new MZHolderCreator() {
            @Override
            public MZViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });
    }

    class BannerViewHolder implements MZViewHolder<Integer> {

        @Override
        public View createView(Context context) {
            // 返回页面布局
            View view = LayoutInflater.from(context).inflate(R.layout.item_banner, null);
            ivBanner = view.findViewById(R.id.banner_image);
            RelativeLayout rlBanner = view.findViewById(R.id.rl_banner);
//            int width = UIUtil.getScreenWidth(context)-StatusBarHelper.dp2px(context, 40);
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width,
//                    LinearLayout.LayoutParams.MATCH_PARENT);
            //设置左右边距
//            params.leftMargin = (int) StatusBarHelper.dp2px(context, 20);
//            params.rightMargin = (int) StatusBarHelper.dp2px(context, 20);
//            rlBanner.setLayoutParams(params);
//            ivBanner.setLayoutParams(params);
            return view;
        }

        @Override
        public void onBind(Context context, int position, Integer data) {
            ivBanner.setImageResource(data);
        }
    }

    private void initData() {
        imageList.add(R.drawable.cherry);
        imageList.add(R.drawable.orange);
        imageList.add(R.drawable.pineapple);
        imageList.add(R.drawable.cherry);

    }

    @Override
    public void onPause() {
        super.onPause();
        //暂停轮播
        banner.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        //开始轮播
        banner.start();
    }
}
