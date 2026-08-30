package com.avl.cagApp.repository.room;

import com.avl.cagApp.model.vo.DeviceInfo;

public interface IDeviceRoomRepository {

    void getInfoByDeviceId(String imei);
    void saveDeviceInfo(DeviceInfo deviceInfo);
}
