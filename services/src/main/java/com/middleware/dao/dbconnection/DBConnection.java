package com.middleware.dao.dbconnection;

import java.io.IOException;

import org.bson.Document;

import com.google.gson.Gson;
import com.middleware.openweatherapp.models.CityWeather;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

public class DBConnection {
	
	private static final String MONGODB_URI = "mongodb+srv://yplasencia:Yosdel123@fligth-data-store.q1tow.mongodb.net/test?retryWrites=true&w=majority";
	private static final String API_WEATHER_DOMAIN = "https://community-open-weather-map.p.rapidapi.com/";
	private static final String DATA_BASE = "fligth-data-store";
	private static final String CITY_WEATHER_CONDITIONS_COLLECTION = "city-weather-conditions";
	
	public static void main(String[] args) {
		
		insertCityWeatherData(getWeatherCityData("California"));
	}
	
	
	
	/**
	 * Method for consuming the api Open Weather Map
	 * The endpoint specifically retrieve the wether data for a specific city.
	 * In case yo want to consult the weather for an specific location you must have to specify
	 * the coordinates.
	 * */
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
			
			System.out.println(cityWeather.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return cityWeather;
	}
	
	
	
	/**
	 * This method it's for inserting into the data base collections of payloads
	 * of the city weather, the city needs to be specified in the method getWeatherCityData
	 * */
	
	static void insertCityWeatherData(CityWeather cityWeather) {
		
		try(MongoClient mongoClient = MongoClients.create(MONGODB_URI)) {
			
			MongoDatabase dataBase = mongoClient.getDatabase(DATA_BASE);
			
			MongoCollection<Document> collection = dataBase.getCollection(CITY_WEATHER_CONDITIONS_COLLECTION);
			
			Gson gson = new Gson();
			
			Document document = Document.parse(gson.toJson(cityWeather));
			
			collection.insertOne(document);
			
		}
	}
}
