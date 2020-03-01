package fun.iardo.myapplication.data;

import android.database.Observable;

import androidx.core.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;

import fun.iardo.myapplication.data.database.WeatherDao;
import fun.iardo.myapplication.data.model.CurrentCondionResponse;
import fun.iardo.myapplication.data.model.CurrentCondition;
import fun.iardo.myapplication.data.model.Imperial;
import fun.iardo.myapplication.data.model.Metric;
import fun.iardo.myapplication.data.model.Temperature;
import io.reactivex.Single;


public class Storage {

    private WeatherDao mWeatherDao;

    public Storage(WeatherDao weatherDao) {
        mWeatherDao = weatherDao;
    }

    public void insertConditions(List<CurrentCondition> response, int locationKey){
        CurrentCondition conditions = response.get(0);
        Temperature temperature = conditions.getTemperature();
        Metric metric = conditions.getTemperature().getMetric();
        Imperial imperial = conditions.getTemperature().getImperial();

        int key = Integer.valueOf(locationKey);
        //AccuWeather выдает наш ключик в String, поэтому переводим тут и добавляем в id
        conditions.setId(key);
        temperature.setId(key);
        temperature.setConditionId(key);
        metric.setTemperatureId(key);
        imperial.setTemperatureId(key);

        mWeatherDao.insertConditions(response);
        mWeatherDao.insertTempereature(temperature);
        mWeatherDao.insertMetric(metric);
        mWeatherDao.insertImperial(imperial);
    }

    public List<CurrentCondition> getConditions(int idKey){

        List<CurrentCondition> conditions = mWeatherDao.getCurrentConditions(idKey);
        Temperature temperature = mWeatherDao.getTemperature(idKey);
        Metric metric = mWeatherDao.getMetric(idKey);
        Imperial imperial = mWeatherDao.getImperial(idKey);
        temperature.setImperial(imperial);
        temperature.setMetric(metric);
        conditions.get(0).setTemperature(temperature);
        return conditions;
    }

    public interface StorageOwner {
        Storage obtainStorage();
    }

}
