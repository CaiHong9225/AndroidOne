package com.erhii.demo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.erhii.TestEventActivity;
import com.erhii.demo.ashmem.client_aidl.ClientBookActivity;
import com.erhii.demo.ashmem.ui.ClienShareMemroylActivity;
import com.erhii.demo.databinding.ui.DataBindingActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * Hello World!
     */
    private TextView mMainid;
    /**
     * Hello World!
     */
    private TextView mMainid2;
    /**
     * DataBinding!
     */
    private TextView mMainid3;
    private TextView mMainid4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mMainid = (TextView) findViewById(R.id.mainid);
        mMainid.setOnClickListener(this);
        mMainid2 = (TextView) findViewById(R.id.mainid2);
        mMainid2.setOnClickListener(this);
        mMainid3 = (TextView) findViewById(R.id.mainid3);
        mMainid3.setOnClickListener(this);
        mMainid4 = (TextView) findViewById(R.id.mainid4);
        mMainid4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.mainid:
                startActivity(new Intent(MainActivity.this, ClienShareMemroylActivity.class));
                break;
            case R.id.mainid2:
                startActivity(new Intent(MainActivity.this, ClientBookActivity.class));
                break;
            case R.id.mainid3:
                startActivity(new Intent(MainActivity.this, DataBindingActivity.class));
                break;
            case R.id.mainid4:
                startActivity(new Intent(MainActivity.this, TestEventActivity.class));
                break;
        }
    }
}
