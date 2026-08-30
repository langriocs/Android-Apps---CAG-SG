package com.avl.cagApp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.avl.cagApp.libs.MyLibUtil;
import com.avl.cagApp.model.vo.DeviceInfo;
import com.avl.cagApp.viewmodel.ShareViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ShareViewModel viewModel = new ViewModelProvider(this).get(ShareViewModel.class);

        String imei = MyLibUtil.getDeviceId(this);
        viewModel.getDeviceInfoByImei(imei);

    }






}