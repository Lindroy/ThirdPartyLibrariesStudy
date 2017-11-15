package com.lindroid.thirdpartylibrariesstudy.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.lindroid.thirdpartylibrariesstudy.R;
import com.mcxtzhang.lib.AnimShopButton;
import com.mcxtzhang.lib.IOnAddDelListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author linyulong
 *         仿饿了么加入购物车旋转控件
 *         博客地址：http://blog.csdn.net/zxt0601/article/details/54235736
 *         使用体验：非常强大，美中不足的是不能修改中间数字的字体颜色
 */
public class AnimShopButtonActivity extends AppCompatActivity {

    @BindView(R.id.btnEle)
    AnimShopButton btnEle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_shop_button);
        ButterKnife.bind(this);
        //加减按钮的监听事件
        btnEle.setOnAddDelListener(new IOnAddDelListener() {
            @Override
            public void onAddSuccess(int i) {
                Log.e("Tag", "onAddSuccess:" + i);
            }

            @Override
            public void onAddFailed(int i, FailType failType) {
                Log.e("Tag", "onAddFailed:" + i);

            }

            @Override
            public void onDelSuccess(int i) {
                Log.e("Tag", "onDelSuccess:" + i);

            }

            @Override
            public void onDelFaild(int i, FailType failType) {
                Log.e("Tag", "onDelSuccess:" + i);

            }
        });

    }

    @OnClick(R.id.btnEle)
    public void onViewClicked() {
    }
}
