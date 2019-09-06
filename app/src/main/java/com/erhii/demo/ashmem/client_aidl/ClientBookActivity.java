package com.erhii.demo.ashmem.client_aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.erhii.demo.R;
import com.erhii.demo.ashmem.BookController;
import com.erhii.demo.ashmem.bean.Book;

import java.util.List;

public class ClientBookActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = "Client";

    private BookController bookController;

    private boolean connected;

    private List<Book> bookList;
    /**
     * 获取书籍列表
     */
    private Button mBtnGetBookList;
    /**
     * InOut 添加书籍
     */
    private Button mBtnAddBookInOut;
    /**
     * In 添加书籍
     */
    private Button mBtnAddBookIn;
    /**
     * Out 添加书籍
     */
    private Button mBtnAddBookOut;

    public ClientBookActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_book);
        initView();
        bindService();
    }

    private void initView() {
        mBtnGetBookList = (Button) findViewById(R.id.btn_getBookList);
        mBtnGetBookList.setOnClickListener(this);
        mBtnAddBookInOut = (Button) findViewById(R.id.btn_addBook_inOut);
        mBtnAddBookInOut.setOnClickListener(this);
        mBtnAddBookIn = (Button) findViewById(R.id.btn_addBook_in);
        mBtnAddBookIn.setOnClickListener(this);
        mBtnAddBookOut = (Button) findViewById(R.id.btn_addBook_out);
        mBtnAddBookOut.setOnClickListener(this);
    }

    private void bindService() {
        Intent intent = new Intent();
        intent.setPackage("com.erhii.demo");
        intent.setAction("com.erhii.aidl.book.server.action");
        bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            bookController = BookController.Stub.asInterface(service);
            connected = true;
            Log.e(TAG, "connected:" + connected);

        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            connected = false;
            Log.e(TAG, "connected:" + connected);
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_getBookList:
                if (connected) {
                    try {
                        bookList = bookController.getBookList();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                    log();
                }
                break;
            case R.id.btn_addBook_inOut:
                if (connected) {
                    Book book = new Book("这是一本新书 InOut");
                    try {
                        bookController.addBookInOut(book);
                        Log.e(TAG, "向服务器以InOut方式添加了一本新书");
                        Log.e(TAG, "新书名：" + book.getName());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.btn_addBook_in:
                if (connected) {
                    Book book = new Book("这是一本新书 In");
                    try {
                        bookController.addBookIn(book);
                        Log.e(TAG, "向服务器以In方式添加了一本新书");
                        Log.e(TAG, "新书名：" + book.getName());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.btn_addBook_out:
                if (connected) {
                    Book book = new Book("这是一本新书 Out");
                    try {
                        Log.e(TAG, "新书名1：" + book.getName());

                        bookController.addBookOut(book);
                        Log.e(TAG, "向服务器以Out方式添加了一本新书");
                        Log.e(TAG, "新书名2：" + book.getName());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (connected) {
            unbindService(serviceConnection);
        }
    }

    private void log() {
        for (Book book : bookList) {
            Log.e(TAG, book.toString());
        }
    }
}
