package com.erhii.demo.services;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.MemoryFile;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import androidx.annotation.RequiresApi;

import com.erhii.demo.ashmem.IMemoryAidlInterface;
import com.erhii.demo.utils.UtilHelper;

import java.io.FileDescriptor;
import java.lang.reflect.Method;

/**
 * 共享内存的服务（Service）
 */
public class MemoryFetchService extends Service {
    public MemoryFetchService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        return new MemoryFetchStub();
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private static byte[] initData() {
        String s = "你好吗1e1e1e1222";
        byte[] bytes = UtilHelper.base64String2ByteFun(s);
        return bytes;
    }

    static class MemoryFetchStub extends IMemoryAidlInterface.Stub {

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public ParcelFileDescriptor getPacceFileDescriptor() throws RemoteException {
            MemoryFile memoryFile = null;
            try {
                memoryFile = new MemoryFile("test_memory", 1024);
                memoryFile.getOutputStream().write(initData());
                Method method = MemoryFile.class.getDeclaredMethod("getFileDescriptor");
                FileDescriptor descriptor = (FileDescriptor) method.invoke(memoryFile);
                return ParcelFileDescriptor.dup(descriptor);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
