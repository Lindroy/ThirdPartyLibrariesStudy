package com.lindroid.thirdpartylibrariesstudy.activity.swiperecyclerview;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.lindroid.thirdpartylibrariesstudy.R;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SwipeRecyclerViewActivity extends AppCompatActivity {

    @BindView(R.id.rv_swipe)
    SwipeMenuRecyclerView rvSwipe;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;

    private List<String> titles = new ArrayList<>();
    private CommonAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_recycler_view);
        ButterKnife.bind(this);
        initData();
        initView();
        loadData();
    }

    private void loadData() {
        if (!titles.isEmpty()) {
            titles.clear();
        }
        for (int i = 1; i <= 50; i++) {
            titles.add(new StringBuffer("标题").append(i).toString());
        }
        adapter.notifyDataSetChanged();
        rvSwipe.loadMoreFinish(false, true);
    }

    private void initView() {
        rvSwipe.setLayoutManager(new LinearLayoutManager(this));
        rvSwipe.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        swipeRefresh.setColorSchemeResources(android.R.color.holo_blue_dark);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.e("Tag", "上拉刷新");
                new Handler(new Handler.Callback() {
                    @Override
                    public boolean handleMessage(Message msg) {
                        swipeRefresh.setRefreshing(false);
                        return false;
                    }
                }).sendEmptyMessageDelayed(0, 2000);
            }
        });

        rvSwipe.useDefaultLoadMore();
        rvSwipe.setLoadMoreListener(new SwipeMenuRecyclerView.LoadMoreListener() {
            @Override
            public void onLoadMore() {
                Log.e("Tag", "下拉加载更多");


              /*  new Handler(new Handler.Callback() {
                    @Override
                    public boolean handleMessage(Message msg) {

                        return false;
                    }
                }).sendEmptyMessageDelayed(0, 2000);*/

                rvSwipe.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 1; i < 5; i++) {
                            titles.add(new StringBuffer("上拉加载的数据").append(i).toString());
                        }
                        adapter.notifyDataSetChanged();
                        rvSwipe.loadMoreFinish(false, titles.size() <= 70);
                    }
                }, 2000);
            }
        });
        rvSwipe.setAdapter(adapter);
    }

    private void initData() {
        adapter = new CommonAdapter<String>(this, android.R.layout.simple_list_item_1, titles) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                holder.setText(android.R.id.text1, s);
            }
        };
    }
}
