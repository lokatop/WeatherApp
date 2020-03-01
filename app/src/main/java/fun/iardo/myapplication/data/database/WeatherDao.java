package fun.iardo.myapplication.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import fun.iardo.myapplication.data.model.AdministrativeArea;
import fun.iardo.myapplication.data.model.Country;
import fun.iardo.myapplication.data.model.CurrentCondition;
import fun.iardo.myapplication.data.model.Imperial;
import fun.iardo.myapplication.data.model.Metric;
import fun.iardo.myapplication.data.model.SearchLocationModel;
import fun.iardo.myapplication.data.model.Temperature;

@Dao
public interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertConditions(List<CurrentCondition> conditions);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTempereature(Temperature temperature);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertImperial(Imperial imperial);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMetric(Metric metric);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertLocationModels(List<SearchLocationModel> models);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertLocationModel(SearchLocationModel models);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCountry(Country country);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAdminAria(AdministrativeArea area);


    @Query("select * from CurrentCondition where id=:cityId")
    List<CurrentCondition> getCurrentConditions(int cityId);
    @Query("select * from CurrentCondition where id=:cityId")
    CurrentCondition getCurrentCondition(int cityId);
    @Query("select * from Temperature where condition_id=:conditionId")
    Temperature getTemperature(int conditionId);
    @Query("select * from Imperial where temperature_id = :temperatureId")
    Imperial getImperial(int temperatureId);
    @Query("select * from Metric where temperature_id = :temperatureId")
    Metric getMetric(int temperatureId);


    @Query("select * from SearchLocationModel")
    List<SearchLocationModel> getLocations();
    @Query("select * from Country where search_location_id=:key")
    Country getCountry(int key);
    @Query("select * from AdministrativeArea where search_location_id = :key")
    AdministrativeArea getArea(int key);


    @Query("delete from CurrentCondition")
    void clearCurrentConditionTable();
    @Query("delete from Temperature")
    void clearTemperatureTable();
    @Query("delete from Imperial")
    void clearImperialTable();
    @Query("delete from Metric")
    void clearMetricTable();

    @Query("delete from SearchLocationModel")
    void clearLocationTable();
    @Query("delete from Country")
    void clearCountryTable();
    @Query("delete from AdministrativeArea")
    void clearAdministrativeAreaTable();

}
