package com.avl.cagApp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import com.avl.cagApp.model.vo.DeviceInfo;
import com.avl.cagApp.repository.room.IDeviceRoomRepository;
import com.avl.cagApp.repository.room.impl.DeviceRoomRepository;

public class ShareViewModel extends ViewModel {
    private final IDeviceRoomRepository deviseRoomRepo;

    public ShareViewModel(@NonNull Application application) {
        super( application);
        deviseRoomRepo = new DeviceRoomRepository(application);
    }

    public void getDeviceInfoByImei(String imei) {

    }
}
