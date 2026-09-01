package com.avl.cagApp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import com.avl.cagApp.model.vo.DeviceInfo;
import com.avl.cagApp.repository.room.IDeviceRoomRepository;
import com.avl.cagApp.repository.room.impl.DeviceRoomRepository;

public class ShareViewModel extends AndroidViewModel {
    private final IDeviceRoomRepository deviceRoomRepo;
    private final MutableLiveData<DeviceInfo> deviceInfo = new MutableLiveData<>();

    public LiveData<DeviceInfo> getDeviceInfo() {
        return deviceInfo;
    }


    public ShareViewModel(@NonNull Application application) {
        super(application);
        deviceRoomRepo = new DeviceRoomRepository(application);

    }

    public void getDeviceInfoByImei(String imei) {

        deviceInfo.postValue(deviceRoomRepo.getInfoByDeviceId(imei).getValue());
    }

}
