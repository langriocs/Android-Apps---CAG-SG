package com.avl.cagApp.repository.room;

import androidx.lifecycle.LiveData;

import com.avl.cagApp.model.vo.ControlDevice;
import com.avl.cagApp.model.vo.ControlRoomDevices;
import com.avl.cagApp.model.vo.RoomDevice;

import java.util.List;

public interface IDeviceRoomRepository {

    LiveData<ControlDevice> fetchControlDeviceByIpAddress(String ipAddress);
    void saveControlDevice(ControlDevice controlDevice);
    void saveRoomDevices(List<RoomDevice> roomDevices);
    void saveControlRoomDevices(ControlDevice controlDevice, List<RoomDevice> roomDevices);
    LiveData<ControlRoomDevices> fetchControlDeviceWithRoomDevicesByIpAddress(String ipAddress);
}
