package com.avl.cagApp.model.vo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "device_info")
public class DeviceInfo {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "imei_id")
    private String imei;
    @ColumnInfo(name = "room_name")
    private String roomName;
    @ColumnInfo(name = "ip_address")
    private String ipAdd;

    @NonNull
    public String getImei() {
        return imei;
    }

    public void setImei(@NonNull String imei) {
        this.imei = imei;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getIpAdd() {
        return ipAdd;
    }

    public void setIpAdd(String ipAdd) {
        this.ipAdd = ipAdd;
    }
}
