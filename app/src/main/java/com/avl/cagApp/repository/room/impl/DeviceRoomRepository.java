package com.avl.cagApp.repository.room.impl;

import android.app.Application;

import com.avl.cagApp.model.vo.DeviceInfo;
import com.avl.cagApp.repository.room.IDeviceRoomRepository;
import com.avl.cagApp.repository.room.RoomDB;
import com.avl.cagApp.repository.room.roomservice.IDeviceInfoDao;

public class DeviceRoomRepository implements IDeviceRoomRepository {

    private RoomDB db;
    private IDeviceInfoDao deviceInfoDao;

    public DeviceRoomRepository(Application application) {
        db = RoomDB.getDatabase(application);
        deviceInfoDao = db.deviceInfoDao();
    }

    @Override
    public void getInfoByDeviceId(String imei) {
        RoomDB.databaseWriteExecutor.execute(() -> {
            deviceInfoDao.getDeviceInfoByImei(imei);
        });

    }

    @Override
    public void saveDeviceInfo(DeviceInfo deviceInfo) {
        RoomDB.databaseWriteExecutor.execute(() -> {
            deviceInfoDao.saveDeviceInfo(deviceInfo);
        });

    }
}
