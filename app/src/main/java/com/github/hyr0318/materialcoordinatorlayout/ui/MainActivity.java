package com.github.hyr0318.materialcoordinatorlayout.ui;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.github.hyr0318.materialcoordinatorlayout.R;
import com.github.hyr0318.materialcoordinatorlayout.listener.OnTabSelectListener;
import com.github.hyr0318.materialcoordinatorlayout.widgets.SlidingTabLayout;
import com.jaeger.library.StatusBarUtil;


public class MainActivity extends BaseActivity implements OnTabSelectListener {

    private CollapsingToolbarLayout collapsingToolbarLayout;
    private AppBarLayout appBarLayout;
    private SlidingTabLayout slidingTabLayout;

    public static String[] mTitles = {
        "综合", "时间", "人气"
    };
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setCollsapsing();
        setViewPager();
    }


    private void setViewPager() {
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);

        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.slidinglayout);

        viewPager = (ViewPager) findViewById(R.id.vp);

        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        slidingTabLayout.setViewPager(viewPager);

        slidingTabLayout.setOnTabSelectListener(this);


    }


    private void setCollsapsing() {

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(
            R.id.collapsing);

        collapsingToolbarLayout.setStatusBarScrim(getResources().getDrawable(R.mipmap.background));

        collapsingToolbarLayout.setContentScrim(getResources().getDrawable(R.mipmap.background));
    }


    @Override protected void setStatusBar() {
        super.setStatusBar();

        StatusBarUtil.setTranslucentForCoordinatorLayout(this, 0);
    }


    @Override public void onTabSelect(int position) {
        TabFragment tabFragment = (TabFragment) viewPager.getAdapter()
            .instantiateItem(viewPager, position);
        tabFragment.OnPagerSelected(position, mTitles[position]);
    }


    @Override public void onTabReselect(int position) {

    }


    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override public Fragment getItem(int position) {
            return TabFragment.getInstance(mTitles[position]);
        }


        @Override public int getCount() {
            return mTitles.length;
        }


        @Override public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }
}
