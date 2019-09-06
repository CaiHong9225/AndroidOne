package com.erhii.mvvm.base;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;



import com.erhii.mvvm.stateview.ErrorState;
import com.erhii.mvvm.stateview.LoadingState;
import com.erhii.mvvm.stateview.StateConstants;
import com.erhii.mvvm.util.TUtil;
import com.tqzhang.stateview.stateview.BaseStateControl;

/**
 * @ProjectName: Demo
 * @Package: com.erhii.mvvm.base
 * @ClassName: AbsLifecycleActivity
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/9/5 15:55
 * @UpdateUser: admin
 * @UpdateDate: 2019/9/5 15:55
 * @UpdateRemark:
 * @Version: 1.0
 */
public class AbsLifecycleActivity<T extends AbsViewModel> extends BaseActivity {
    protected T mViewModel;

    public AbsLifecycleActivity() {

    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        mViewModel = VMProviders(this, (Class<T>) TUtil.getInstance(this, 0));
        dataObserver();
    }


    protected <T extends ViewModel> T VMProviders(AppCompatActivity fragment, @NonNull Class modelClass) {
        return (T) ViewModelProviders.of(fragment).get(modelClass);

    }

    protected void dataObserver() {

    }

    @Override
    protected void onStateRefresh() {
        showLoading();
    }

    @Override
    public int getLayoutId() {
        return 0;
    }

    protected void showError(Class<? extends BaseStateControl> stateView, Object tag) {
        mLoadManager.showStateView(stateView, tag);
    }

    protected void showError(Class<? extends BaseStateControl> stateView) {
        showError(stateView, null);
    }

    protected void showSuccess() {
        mLoadManager.showSuccess();
    }

    protected void showLoading() {
        mLoadManager.showStateView(LoadingState.class);
    }


    protected Observer observer = new Observer<String>() {
        @Override
        public void onChanged(@Nullable String state) {
            if (!TextUtils.isEmpty(state)) {
                if (StateConstants.ERROR_STATE.equals(state)) {
                    showError(ErrorState.class, "2");
                } else if (StateConstants.NET_WORK_STATE.equals(state)) {
                    showError(ErrorState.class, "1");
                } else if (StateConstants.LOADING_STATE.equals(state)) {
                    showLoading();
                } else if (StateConstants.SUCCESS_STATE.equals(state)) {
                    showSuccess();
                }
            }
        }
    };
}
