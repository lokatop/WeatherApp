package fun.iardo.myapplication;

import android.app.Application;

/**
 * Created by Vladislav Falzan.
 */

public class AppDelegate extends Application {

    //private Storage mStorage;

    @Override
    public void onCreate() {
        super.onCreate();

//        final BehanceDatabase database = Room.databaseBuilder(this, BehanceDatabase.class, "behance_database")
//                .fallbackToDestructiveMigration()
//                .build();
//
//        mStorage = new Storage(database.getBehanceDao());
    }
/*
    public Storage getStorage() {
        return mStorage;
    }
    */
}
