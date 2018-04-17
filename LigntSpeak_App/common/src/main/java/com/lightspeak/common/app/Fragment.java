package com.lightspeak.common.app;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class Fragment extends android.support.v4.app.Fragment {
    protected View view;
    protected Unbinder unbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initArgs(getArguments());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view != null) {
            int layoutId = getContentLayoutId();
            View view = inflater.inflate(layoutId, container, false);
            this.unbinder = ButterKnife.bind(this, view);
            initWidget(view);
            this.view = view;
        } else {
            if (view.getParent() != null) {
                //把当前view从夫控件中移除
                ((ViewGroup) view.getParent()).removeView(view);
            }
        }
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    /**
     * 获取布局id
     *
     * @return 布局id
     */
    public abstract int getContentLayoutId();

    /**
     * 初始化相关参数
     *
     * @param bundle 传入的相关参数
     */
    protected void initArgs(Bundle bundle) {

    }

    /**
     * 初始化控件
     *
     * @param view
     */
    protected void initWidget(View view) {

    }

    /**
     * 初始化数据
     */
    protected void initData() {

    }

    /**
     * 返回按键触发时调用
     *
     * @return 返回True代表我已处理返回逻辑，Activity不用自己finish。
     * 返回False代表我没有处理逻辑，Activity自己走自己的逻辑
     */
    public boolean onBackPressed() {
        return false;
    }
}
