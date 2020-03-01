package fun.iardo.myapplication;

import android.app.Application;

import androidx.room.Room;

import fun.iardo.myapplication.data.Storage;
import fun.iardo.myapplication.data.database.WeatherDatabase;

/**
 * Created by Vladislav Falzan.
 */

public class AppDelegate extends Application {

    private Storage mStorage;

    @Override
    public void onCreate() {
        super.onCreate();

        final WeatherDatabase database = Room.databaseBuilder(this, WeatherDatabase.class, "weather_database")
                .fallbackToDestructiveMigration()
                .build();

        mStorage = new Storage(database.getWeatherDao());
    }

    public Storage getStorage() {
        return mStorage;
    }
}
