package com.avl.cagApp.repository.room.roomservice;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.avl.cagApp.model.vo.DeviceInfo;
@Dao
public interface IDeviceInfoDao {
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveDeviceInfo(DeviceInfo deviceInfo);

    @Transaction
    @Query("SELECT * FROM device_info WHERE imei = :imei")
    DeviceInfo getDeviceInfoByImei(String imei);
}
