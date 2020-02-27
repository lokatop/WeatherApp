package fun.iardo.myapplication.data.api;

import java.util.List;

import fun.iardo.myapplication.data.model.CurrentCondition;
import fun.iardo.myapplication.data.model.SearchLocationModel;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IWeatherApi {
    @GET("currentconditions/v1/{key}")
    Observable<List<CurrentCondition>> getAccuWeatherData(@Path("key") String cityKey, @Query("apikey") String appId);

    @GET("locations/v1/cities/autocomplete")
    Observable<List<SearchLocationModel>> getAccuWeatherCities(@Query("apikey") String appId, @Query("q") String query);

}
