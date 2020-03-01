package fun.iardo.myapplication.data;

import java.util.ArrayList;
import java.util.List;

import fun.iardo.myapplication.data.database.WeatherDao;
import fun.iardo.myapplication.data.model.CurrentCondionResponse;
import fun.iardo.myapplication.data.model.CurrentCondition;


public class Storage {

    private WeatherDao mWeatherDao;

    public Storage(WeatherDao weatherDao) {
        mWeatherDao = weatherDao;
    }

    public void insertCondition(CurrentCondionResponse response){
        List<CurrentCondition> conditions = response.getCurrents();
        mWeatherDao.insertConditions(conditions);


    }

    public interface StorageOwner {
        Storage obtainStorage();
    }

}
