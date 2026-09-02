package com.avl.cagApp.repository.room;

import androidx.lifecycle.LiveData;

import com.avl.cagApp.model.vo.DeviceInfo;

public interface IDeviceRoomRepository {

    LiveData<DeviceInfo> fetchInfoByDeviceId(String imei);
    void saveDeviceInfo(DeviceInfo deviceInfo);
}
