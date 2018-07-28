package com.lindroid.thirdpartylibrariesstudy.activity.smartrefresh;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.lindroid.thirdpartylibrariesstudy.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SmartRefreshActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    //    private MaterialHeader materialHeader;
    private List<String> titles = new ArrayList<>();
    private CommonAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_refresh);
        ButterKnife.bind(this);

        initData();
        initView();
        loadData();
    }

    private void initView() {
//        ClassicsFooter.REFRESH_FOOTER_NOTHING = "数据都加载完了";
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
       /* materialHeader = (MaterialHeader) refreshLayout.getRefreshHeader();
        if (materialHeader != null) {
            materialHeader.setColorSchemeResources(android.R.color.holo_blue_dark);
        }*/
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull final RefreshLayout refreshLayout) {
                new Handler(new Handler.Callback() {
                    @Override
                    public boolean handleMessage(Message msg) {
                        loadData();
                        Toast.makeText(SmartRefreshActivity.this, "刷新完成", Toast.LENGTH_SHORT).show();
                        refreshLayout.finishRefresh();
                        return false;
                    }
                }).sendEmptyMessageDelayed(0, 1500);
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull final RefreshLayout refreshLayout) {
                new Handler(new Handler.Callback() {
                    @Override
                    public boolean handleMessage(Message msg) {
                        if (titles.size() <= 60) {
                            for (int i = 1; i <= 5; i++) {
                                titles.add(new StringBuffer("这是新加的数据").append(i).toString());
                            }
                        } else {
                            refreshLayout.finishLoadMoreWithNoMoreData();
                        }
                        adapter.notifyDataSetChanged();
                        refreshLayout.finishLoadMore();
                        return false;
                    }
                }).sendEmptyMessageDelayed(0, 1500);
            }
        });
    }

    private void initData() {
        adapter = new CommonAdapter<String>(this, android.R.layout.simple_list_item_1, titles) {
            @Override
            protected void convert(ViewHolder holder, String s, int position) {
                holder.setText(android.R.id.text1, s);
            }
        };
        recyclerView.setAdapter(adapter);
    }

    private void loadData() {
        if (!titles.isEmpty()) {
            titles.clear();
        }
        for (int i = 1; i <= 50; i++) {
            titles.add(new StringBuffer("标题").append(i).toString());
        }
        adapter.notifyDataSetChanged();
    }
}
