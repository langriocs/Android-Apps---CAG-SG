package com.avl.cagApp.model.vo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "control_device")
public class ControlDevice {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "ip_address")
    private String ipAdd;

    @ColumnInfo(name = "room_name")
    private String roomName;

    @NonNull
    public String getIpAdd() {
        return ipAdd;
    }

    public void setIpAdd(String ipAdd) {
        this.ipAdd = ipAdd;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }


}
