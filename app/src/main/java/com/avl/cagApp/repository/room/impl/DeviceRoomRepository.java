package com.avl.cagApp.repository.room.impl;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.avl.cagApp.model.vo.ControlDevice;
import com.avl.cagApp.model.vo.ControlRoomDevices;
import com.avl.cagApp.model.vo.RoomDevice;
import com.avl.cagApp.repository.room.IDeviceRoomRepository;
import com.avl.cagApp.repository.room.RoomDB;
import com.avl.cagApp.repository.room.roomservice.ControlDeviceDao;

import java.util.List;

public class DeviceRoomRepository implements IDeviceRoomRepository {

    private RoomDB db;
    private ControlDeviceDao controlDeviceDao;

    public DeviceRoomRepository(Application application) {
        db = RoomDB.getDatabase(application);
        controlDeviceDao = db.deviceInfoDao();
    }

    @Override
    public LiveData<ControlDevice> fetchControlDeviceByIpAddress(String ipAddress) {
        return controlDeviceDao.getControlDeviceByIpAddress(ipAddress);
    }

    @Override
    public void saveControlDevice(ControlDevice controlDevice) {
        RoomDB.databaseWriteExecutor.execute(() -> {
            controlDeviceDao.saveControlDevice(controlDevice);
        });
    }



    @Override
    public void saveRoomDevices(List<RoomDevice> roomDevices) {
        RoomDB.databaseWriteExecutor.execute(() -> {
            controlDeviceDao.saveRoomDevices(roomDevices);
        });
    }

    @Override
    public void saveControlRoomDevices(ControlDevice controlDevice, List<RoomDevice> roomDevices) {
        RoomDB.databaseWriteExecutor.execute(() -> {
            controlDeviceDao.saveControlRoomDevices(controlDevice, roomDevices);
        });
    }

    @Override
    public LiveData<ControlRoomDevices> fetchControlDeviceWithRoomDevicesByIpAddress(String ipAddress) {
        return controlDeviceDao.getControlDeviceWithRoomDevicesByIpAddress(ipAddress);
    }
}
