package fun.iardo.myapplication.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import fun.iardo.myapplication.data.model.AdministrativeArea;
import fun.iardo.myapplication.data.model.Country;
import fun.iardo.myapplication.data.model.CurrentCondition;
import fun.iardo.myapplication.data.model.Imperial;
import fun.iardo.myapplication.data.model.Metric;
import fun.iardo.myapplication.data.model.SearchLocationModel;
import fun.iardo.myapplication.data.model.Temperature;

@Database(entities = {CurrentCondition.class, Temperature.class, Imperial.class, Metric.class, SearchLocationModel.class, Country.class, AdministrativeArea.class}, version = 1)
public abstract class WeatherDatabase extends RoomDatabase {
    public abstract WeatherDao getWeatherDao();
}
