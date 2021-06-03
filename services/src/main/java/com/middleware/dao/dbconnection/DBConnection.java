package com.middleware.dao.dbconnection;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.google.gson.Gson;
import com.middleware.dto.CityWeather;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

public class DBConnection {
	
	private static final String MONGODB_URI = "mongodb+srv://yplasencia:Yosdel123@fligth-data-store.q1tow.mongodb.net/test?retryWrites=true&w=majority";
	private static final String API_WEATHER_DOMAIN = "https://community-open-weather-map.p.rapidapi.com/";
	
	public static void main(String[] args) {
//		try(MongoClient mongoClient = MongoClients.create(MONGODB_URI)) {
//			List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
//			databases.forEach(db -> System.out.println(db.toJson()));
//		}
		
		getWeatherCityData("New York");

	}
	
	
	static CityWeather getWeatherCityData(String city) {
		OkHttpClient client = new OkHttpClient();
		CityWeather cityWeather = new CityWeather();

		Request request = new Request.Builder()
			.url(API_WEATHER_DOMAIN + "find?q=" + city + "&cnt=1&type=accurate")
			.get()
			.addHeader("x-rapidapi-key", "77e6b227aemsh2b1c008dda3228fp10b4fajsn2ec8446155da")
			.addHeader("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
			.build();

		try {
			Response response = client.newCall(request).execute();
			ResponseBody responseBody = response.body();
			
			Gson gson = new Gson();
			
			cityWeather = gson.fromJson(responseBody.string(), CityWeather.class);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return cityWeather;
	}
}
