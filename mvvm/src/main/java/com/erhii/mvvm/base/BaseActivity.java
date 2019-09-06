package com.erhii.mvvm.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


import com.tqzhang.stateview.core.LoadManager;
import com.tqzhang.stateview.stateview.BaseStateControl;

/**
 * @ProjectName: Demo
 * @Package: com.erhii.mvvm.base
 * @ClassName: BaseActivity
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/9/5 14:44
 * @UpdateUser: admin
 * @UpdateDate: 2019/9/5 14:44
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected LoadManager mLoadManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initStatusBar();
        setContentView(getLayoutId());

        mLoadManager = new LoadManager.Builder()
                .setViewParams(this)
                .setListener(new BaseStateControl.OnRefreshListener() {
                    @Override
                    public void onRefresh(View view) {
                        onStateRefresh();
                    }
                }).build();
        initViews(savedInstanceState);

        initToolBar();
    }

    /**
     *
     */
    protected void onStateRefresh() {

    }


    protected void initStatusBar() {

    }


    /**
     * 设置布局layout
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 初始化views
     *
     * @param savedInstanceState
     */
    public abstract void initViews(Bundle savedInstanceState);

    /**
     * 初始化toolbar
     */
    protected void initToolBar() {
        //doSomething
    }


    /**
     * 显示进度条
     */
    public void showProgressBar() {
    }

    /**
     * 隐藏进度条
     */
    public void hideProgressBar() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
