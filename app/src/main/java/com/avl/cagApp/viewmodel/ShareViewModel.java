package com.avl.cagApp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.avl.cagApp.model.vo.DeviceInfo;
import com.avl.cagApp.repository.room.IDeviceRoomRepository;
import com.avl.cagApp.repository.room.impl.DeviceRoomRepository;

public class ShareViewModel extends AndroidViewModel {
    private final IDeviceRoomRepository deviceRoomRepo;
    private final MutableLiveData<String> imeiQuery = new MutableLiveData<>();
    private LiveData<DeviceInfo> deviceInfo;

    public ShareViewModel(@NonNull Application application) {
        super(application);
        deviceRoomRepo = new DeviceRoomRepository(application);
        deviceInfo = Transformations.switchMap(imeiQuery, deviceRoomRepo::fetchInfoByDeviceId);
    }

    public LiveData<DeviceInfo> deviceInfoByImei() {
        return deviceInfo;
    }



    public void fetchDeviceInfoByImei(String imei) {
        imeiQuery.setValue(imei);
    }


    public void saveDeviceInfo(DeviceInfo device) {
        deviceRoomRepo.saveDeviceInfo(device);
    }
}
