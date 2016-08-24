package com.github.hyr0318.materialcoordinatorlayout.ui;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;

/**
 * Description:
 * 作者：hyr on 2016/8/24 14:06
 * 邮箱：2045446584@qq.com
 */
public class BaseActivity extends AppCompatActivity {

    @Override public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);

        setStatusBar();
    }


    protected void setStatusBar() {

    }
}
