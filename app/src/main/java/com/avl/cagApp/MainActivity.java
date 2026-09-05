package com.avl.cagApp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.lifecycle.ViewModelProvider;

import com.avl.cagApp.libs.MyLibUtil;
import com.avl.cagApp.model.vo.ControlDevice;
import com.avl.cagApp.model.vo.RoomDevice;
import com.avl.cagApp.viewmodel.ShareViewModel;

import java.util.ArrayList;
import java.util.List;

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

        ShareViewModel viewModel = new ViewModelProvider(this).get(ShareViewModel.class);
        viewModel.getControlRoomDevices().observe(this, data -> {
            if (data == null) {
                // 1. Create the Master (ControlDeviceInfo)
                ControlDevice controlDevice = new ControlDevice();
                controlDevice.setIpAdd("192.168.1.10");
                controlDevice.setRoomName("Airline Room 1");


                // 2. Create the Children (DeviceInfo)
                List<RoomDevice> roomDevices = new ArrayList<>();
                
                RoomDevice roomDevice1 = new RoomDevice();
                roomDevice1.setParentIpAddress("192.168.1.10");
                roomDevice1.setDeviceName("Switch");
                roomDevice1.setDeviceDesc("Main Switch Hub");
//                roomDevice1.setDeviceIpAddress("192.168.1.11");
                roomDevice1.setDeviceIpAddress("10.0.2.2");
                roomDevice1.setDevicePort(8000);
                roomDevices.add(roomDevice1);

                RoomDevice roomDevice2 = new RoomDevice();
                roomDevice2.setParentIpAddress("192.168.1.10");
                roomDevice2.setDeviceName("TV");
                roomDevice2.setDeviceDesc("LG TV");
                roomDevice2.setDeviceIpAddress("192.168.1.12");
                roomDevice2.setDevicePort(9761);
                roomDevices.add(roomDevice2);

                // 3. Save to database
                viewModel.saveControlRoomDevices(controlDevice, roomDevices);
            }
        });

        final String ipAddress = "192.168.1.10"; //MyLibUtil.getIPAddress(true);
        viewModel.fetchControlDeviceByIpAddress(ipAddress);

    }
}