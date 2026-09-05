package com.avl.cagApp.model.vo;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class ControlRoomDevices {
    @Embedded
    public ControlDevice controlDeviceInfo;

    @Relation(
        parentColumn = "ip_address",
        entityColumn = "parent_ip_address"
    )
    public List<RoomDevice> deviceInfos;
}
