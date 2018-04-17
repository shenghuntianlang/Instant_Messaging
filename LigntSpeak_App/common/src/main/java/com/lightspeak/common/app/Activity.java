package com.lightspeak.common.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import butterknife.ButterKnife;

/**
 * 程序所有activity的父类模板
 */
public abstract class Activity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在界面未初始化前调用的初始化窗口
        initWindows();

        //接收传递过来的参数并进行初始化
        if (initArgs(getIntent().getExtras())) {
            //如果成功初始化数据后的操作
            int layoutId = getContentLayoutId();
            setContentView(layoutId);
            ButterKnife.bind(this);

            initWidget();
            initData();
        } else {
            finish();
        }
    }

    /**
     * 获取布局id
     *
     * @return 布局id
     */
    public abstract int getContentLayoutId();

    /**
     * 初始化窗口
     */
    protected void initWindows() {

    }

    /**
     * 初始化相关参数
     *
     * @param bundle 数据源参数bundle
     * @return 参数是否正确
     */
    protected boolean initArgs(Bundle bundle) {
        return true;
    }

    /**
     * 初始化数据
     */
    protected void initData() {

    }

    /**
     * 初始化控件
     */
    protected void initWidget() {

    }

    @Override
    public boolean onSupportNavigateUp() {
        //当点击界面导航返回时,关闭该界面
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        //获取当前activity下的所有fragment
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        //对获取到的fragment list进行判空
        if (fragments != null && fragments.size() > 0) {
            for (Fragment fragment :
                    fragments) {
                //判断是否为可处理的fragment类型
                if (fragment instanceof com.lightspeak.common.app.Fragment) {
                    //判断是否拦截返回按钮
                    if (((com.lightspeak.common.app.Fragment) fragment).onBackPressed()) {
                        //如果有直接返回
                        return;
                    }
                }
            }
        }
        super.onBackPressed();
        finish();
    }
}
