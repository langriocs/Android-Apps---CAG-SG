package com.avl.cagApp.model.vo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(
    tableName = "room_device",
    foreignKeys = @ForeignKey(
        entity = ControlDevice.class,
        parentColumns = "ip_address",
        childColumns = "parent_ip_address",
        onDelete = CASCADE
    ),
    indices = {@Index("parent_ip_address")}
)
public class RoomDevice {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "parent_ip_address")
    private String parentIpAddress;

    @ColumnInfo(name = "device_name")
    private String deviceName;
    
    @ColumnInfo(name = "device_desc")
    private String deviceDesc;
    
    @ColumnInfo(name = "device_ip_address")
    private String deviceIpAddress;
    
    @ColumnInfo(name = "device_port")
    private int devicePort;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParentIpAddress() {
        return parentIpAddress;
    }

    public void setParentIpAddress(String ipAddress) {
        this.parentIpAddress = ipAddress;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceDesc() {
        return deviceDesc;
    }

    public void setDeviceDesc(String deviceDesc) {
        this.deviceDesc = deviceDesc;
    }

    public String getDeviceIpAddress() {
        return deviceIpAddress;
    }

    public void setDeviceIpAddress(String deviceIpAddress) {
        this.deviceIpAddress = deviceIpAddress;
    }

    public int getDevicePort() {
        return devicePort;
    }

    public void setDevicePort(int devicePort) {
        this.devicePort = devicePort;
    }


}
