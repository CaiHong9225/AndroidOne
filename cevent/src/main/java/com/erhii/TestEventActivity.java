package com.erhii;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.erhii.cevent.R;
import com.erhii.cevent.listener.CEventCenter;
import com.erhii.cevent.listener.I_CEventListener;

public class TestEventActivity extends AppCompatActivity implements I_CEventListener, View.OnClickListener {

    /**
     * adadadad
     */
    private TextView mText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_event);
        initView();
        CEventCenter.registerEventListener(this, "test1");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        CEventCenter.unregisterEventListener(this, "test1");
    }

    @Override
    public void onCEvent(String topic, int msgCode, int resultCode, Object obj) {
        mText1.setText((String) obj);
    }

    private void initView() {
        mText1 = (TextView) findViewById(R.id.text1);
        mText1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.text1) {
            startActivity(new Intent(this, TestEvent2Activity.class));
        }
    }
}
