package com.erhii.demo.ashmem.ui;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.erhii.demo.R;
import com.erhii.demo.ashmem.IMemoryAidlInterface;
import com.erhii.demo.utils.UtilHelper;

import java.io.FileDescriptor;
import java.io.FileInputStream;

/**
 * 进程共享内存 演示（代替intent传值）
 */
public class ClienShareMemroylActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG ="ClienShareMemroy";
    /**
     * 点击
     */
    private TextView mClientAidlTv;

    private IMemoryAidlInterface aidlInterface;

    private boolean isServiceConnected =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_aidl);
        initView();
        bindSevice();
    }

    private void initView() {
        mClientAidlTv = (TextView) findViewById(R.id.client_aidl_tv);
        mClientAidlTv.setOnClickListener(this);
    }

    private byte[] content;

    private void bindSevice() {
        Intent intent = new Intent();
        intent.setPackage("com.erhii.demo");
        intent.setAction("com.erhii.aidl.server.action");

        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                isServiceConnected = true;
                Log.e(TAG, "service：" + isServiceConnected);

                content = new byte[1024];
                aidlInterface = IMemoryAidlInterface.Stub.asInterface(service);
                try {
                    ParcelFileDescriptor pacceFileDescriptor = aidlInterface.getPacceFileDescriptor();
                    FileDescriptor fileDescriptor = pacceFileDescriptor.getFileDescriptor();
                    FileInputStream fileInputStream = new FileInputStream(fileDescriptor);
                    fileInputStream.read(content);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                isServiceConnected = false;
                Log.e(TAG, "service：" + isServiceConnected);
            }
        }, Service.BIND_AUTO_CREATE);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.client_aidl_tv:
                if(content.length>0){
                    String s1 = UtilHelper.byte2Base64StringFun(content);
                    Log.e(TAG, "serviceContent：" + s1);
                    mClientAidlTv.setText(s1);
                }
                break;
        }
    }
}
