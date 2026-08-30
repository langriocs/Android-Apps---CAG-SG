package com.avl.cagApp.repository.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.avl.cagApp.model.vo.DeviceInfo;
import com.avl.cagApp.repository.room.roomservice.IDeviceInfoDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {
        DeviceInfo.class
}, version = 1, exportSchema = false)

public abstract class RoomDB extends RoomDatabase {

    public abstract IDeviceInfoDao deviceInfoDao();

    private static volatile RoomDB  INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static RoomDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoomDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    RoomDB.class, "roomDB")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
