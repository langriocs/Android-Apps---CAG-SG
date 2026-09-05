package com.avl.cagApp.repository.room.roomservice;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.avl.cagApp.model.vo.ControlDevice;
import com.avl.cagApp.model.vo.RoomDevice;

import java.util.List;

@Dao
public interface IDeviceInfoDao {
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveControlDevice(ControlDevice deviceInfo);

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveRoomDevices(List<RoomDevice> roomDevices);

    @Transaction
    @Query("SELECT * FROM control_device WHERE ip_address = :ipAddress")
    LiveData<ControlDevice> getControlDeviceByIpAddress(String ipAddress);
}
