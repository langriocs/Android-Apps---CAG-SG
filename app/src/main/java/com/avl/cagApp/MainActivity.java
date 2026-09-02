package com.avl.cagApp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
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

        // Hide system bars for a truly full screen immersive experience
        WindowInsetsControllerCompat windowInsetsController =
                ViewCompat.getWindowInsetsController(getWindow().getDecorView());
        if (windowInsetsController != null) {
            windowInsetsController.setSystemBarsBehavior(
                    WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            );
            windowInsetsController.hide(WindowInsetsCompat.Type.systemBars());
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            return insets;
        });

        final String imei = MyLibUtil.getDeviceId(this);

        ShareViewModel viewModel = new ViewModelProvider(this).get(ShareViewModel.class);
        viewModel.deviceInfoByImei().observe(this, deviceInfo -> {
            if (deviceInfo == null) {
                DeviceInfo device = new DeviceInfo();
                device.setImei(imei);
                device.setRoomName("Training Room");
                device.setIpAdd("192.168.1.10");
                device.setPort(8000);

                viewModel.saveDeviceInfo(device);
            }
        });

        viewModel.fetchDeviceInfoByImei(imei);

    }
}