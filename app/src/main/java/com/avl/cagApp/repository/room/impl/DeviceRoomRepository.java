package com.avl.cagApp.repository.room.impl;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.avl.cagApp.model.vo.ControlDevice;
import com.avl.cagApp.model.vo.RoomDevice;
import com.avl.cagApp.repository.room.IDeviceRoomRepository;
import com.avl.cagApp.repository.room.RoomDB;
import com.avl.cagApp.repository.room.roomservice.IDeviceInfoDao;

import java.util.List;

public class DeviceRoomRepository implements IDeviceRoomRepository {

    private RoomDB db;
    private IDeviceInfoDao deviceInfoDao;

    public DeviceRoomRepository(Application application) {
        db = RoomDB.getDatabase(application);
        deviceInfoDao = db.deviceInfoDao();
    }

    @Override
    public LiveData<ControlDevice> fetchControlDeviceByIpAddress(String ipAddress) {
        return deviceInfoDao.getControlDeviceByIpAddress(ipAddress);
    }

    @Override
    public void saveControlDevice(ControlDevice controlDevice) {
        RoomDB.databaseWriteExecutor.execute(() -> {
            deviceInfoDao.saveControlDevice(controlDevice);
        });
    }



    @Override
    public void saveRoomDevices(List<RoomDevice> roomDevices) {
        RoomDB.databaseWriteExecutor.execute(() -> {
            deviceInfoDao.saveRoomDevices(roomDevices);
        });
    }
}
