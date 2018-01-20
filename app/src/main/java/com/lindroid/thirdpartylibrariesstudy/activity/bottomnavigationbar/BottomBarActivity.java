package com.lindroid.thirdpartylibrariesstudy.activity.bottomnavigationbar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.lindroid.thirdpartylibrariesstudy.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author linyulong
 */
public class BottomBarActivity extends AppCompatActivity {

    @BindView(R.id.bottomBar)
    BottomNavigationBar bottomBar;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_bar);
        ButterKnife.bind(this);
        bottomBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomBar.addItem(new BottomNavigationItem(R.mipmap.ic_home_white_24dp, "首页").setActiveColorResource(android.R.color.holo_orange_dark))
                .addItem(new BottomNavigationItem(R.mipmap.ic_book_white_24dp, "书籍"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_tv_white_24dp, "电视"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_videogame_asset_white_24dp, "游戏"))
                .addItem(new BottomNavigationItem(R.mipmap.ic_music_note_white_24dp, "音乐"))
                .setFirstSelectedPosition(0)
                .initialise();
        initViewPager();
        //BottomNavigationBar的选择监听事件
        bottomBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                Toast.makeText(BottomBarActivity.this, "你点击了" + position, Toast.LENGTH_SHORT).show();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });


    }

    private void initViewPager() {
        fragmentList.add(new TestFragment("首页"));
        fragmentList.add(new TestFragment("书籍"));
        fragmentList.add(new TestFragment("电视"));
        fragmentList.add(new TestFragment("游戏"));
        fragmentList.add(new TestFragment("音乐"));

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomBar.selectTab(position, false);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void changeTab(View view) {
        //第二个参数为false时不调用OnTabSelectedListener中的onTabSelected方法
        bottomBar.selectTab(2, false);
    }
}
