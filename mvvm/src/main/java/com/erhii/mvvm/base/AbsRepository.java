package com.erhii.mvvm.base;

import android.arch.lifecycle.MutableLiveData;


import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @ProjectName: Demo
 * @Package: com.erhii.mvvm.base
 * @ClassName: AbsRepository
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/9/5 14:23
 * @UpdateUser: admin
 * @UpdateDate: 2019/9/5 14:23
 * @UpdateRemark:
 * @Version: 1.0
 */
public abstract class AbsRepository {
    private CompositeDisposable mCompositeDisposable;
    public MutableLiveData<String> loadState;


    public AbsRepository() {
        loadState = new MutableLiveData<>();
    }
    protected void postState(String state){
        if(loadState != null){
            loadState.postValue(state);
        }
    }
    protected void addDisposable(Disposable disposable){
        if(mCompositeDisposable==null){
            mCompositeDisposable  = new CompositeDisposable();
        }
        mCompositeDisposable.add(disposable);
    }
    protected void unDisposable(){
        if(mCompositeDisposable!=mCompositeDisposable){
            mCompositeDisposable.clear();
        }
    }
}
