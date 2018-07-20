package com.lindroid.thirdpartylibrariesstudy.activity.swiperecyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lindroid.thirdpartylibrariesstudy.R;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;

/**
 * @author Lin
 * @date 2018/7/19
 * @function 自定义加载更多布局
 */
public class CustomLoadMoreView extends LinearLayout implements SwipeMenuRecyclerView.LoadMoreView, View.OnClickListener {
    //    private LoadingView mLoadingView;
    private TextView tvLoadMore;

    public CustomLoadMoreView(Context context) {
        super(context);
        setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        setGravity(Gravity.CENTER);
        setVisibility(GONE);

        inflate(context, R.layout.load_more_view, this);
        tvLoadMore = findViewById(R.id.tvLoadMore);
        setOnClickListener(this);
    }

    public CustomLoadMoreView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLoadMoreView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onLoading() {
        setVisibility(VISIBLE);
        tvLoadMore.setVisibility(VISIBLE);
        tvLoadMore.setText("玩命加载中…");
    }

    @Override
    public void onLoadFinish(boolean dataEmpty, boolean hasMore) {
        setVisibility(GONE);
    }

    @Override
    public void onWaitToLoadMore(SwipeMenuRecyclerView.LoadMoreListener loadMoreListener) {

    }

    @Override
    public void onLoadError(int i, String s) {

    }
}
