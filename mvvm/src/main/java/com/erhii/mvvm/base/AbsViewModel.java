package com.erhii.mvvm.base;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;


import com.erhii.mvvm.util.TUtil;

/**
 * @ProjectName: Demo
 * @Package: com.erhii.mvvm.base
 * @ClassName: AbsViewModel
 * @Description: java类作用描述
 * @Author: admin
 * @CreateDate: 2019/9/5 10:57
 * @UpdateUser: admin
 * @UpdateDate: 2019/9/5 10:57
 * @UpdateRemark:
 * @Version: 1.0
 */
public class AbsViewModel<T extends AbsRepository> extends AndroidViewModel {
    public T mRepository;

    public AbsViewModel(@NonNull Application application) {
        super(application);
        mRepository = TUtil.getNewInstance(this,0);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if(mRepository!=null){
            mRepository.unDisposable();
        }
    }
}
