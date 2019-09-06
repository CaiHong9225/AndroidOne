package com.erhii.demo.databinding.ui;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.erhii.demo.R;
import com.erhii.demo.databinding.User;

public class DataBindingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.erhii.demo.databinding.ActivityDataBindingBinding viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);

        User user = new User("你好", "LiLANG");
        viewDataBinding.setUser(user);
        viewDataBinding.setFirstName("zhang");
        viewDataBinding.setLastName("laingying");
    }
}
