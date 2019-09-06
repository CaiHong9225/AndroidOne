package com.erhii;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.erhii.cevent.R;
import com.erhii.cevent.listener.CEventCenter;

public class TestEvent2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_event2);

        CEventCenter.dispatchEvent("test1", 0, 0, "草草哦啊哦");
    }
}
