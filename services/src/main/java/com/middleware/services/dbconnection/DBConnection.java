package com.middleware.services.dbconnection;

import java.io.IOException;

import org.bson.Document;

import com.google.gson.Gson;
import com.middleware.services.dbconnection.nationalweatherservices.station.observation.models.StationWeather;
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
	private static final String API_WEATHER_DOMAIN = "https://api.weather.gov";
	private static final String DATA_BASE = "fligth-data-store";
	private static final String CITY_WEATHER_CONDITIONS_COLLECTION = "stations-weather-conditions";
	private static final String[] PRINCIPAL_STATIONS = {"KLGA", "KIAH", "KLAX", "KATL", "KJFK", "KSFO", "KORD", "KDFW", "KDEN"};
	
	public static void main(String[] args) {
		
		for (String station : PRINCIPAL_STATIONS) {
			insertCityWeatherData(getWeatherCityData(station));
		}
	}
	
	
	
	/**
	 * Method for consuming the national weather service api
	 * specifically the endpoint /stations/{stationId}/observations
	 * that give us the weather observation for an specyfic airport station
	 * */
	static StationWeather getWeatherCityData(String stationId) {
		OkHttpClient client = new OkHttpClient();
		StationWeather stationWeather = new StationWeather();

		Request request = new Request.Builder()
			.url(API_WEATHER_DOMAIN + "/stations/" + stationId + "/observations?limit=1")
			.get()
			.addHeader("Accept", "application/json")
			.build();

		try {
			Response response = client.newCall(request).execute();
			ResponseBody responseBody = response.body();
			
			Gson gson = new Gson();
			
			stationWeather = gson.fromJson(responseBody.string(), StationWeather.class);
			
			System.out.println(stationWeather.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return stationWeather;
		
	}
	
	
	
	/**
	 * This method it's for inserting into the data base collections of payloads
	 * of the city weather, the city needs to be specified in the method getWeatherCityData
	 * */
	
	static void insertCityWeatherData(StationWeather stationWeather) {
		
		try(MongoClient mongoClient = MongoClients.create(MONGODB_URI)) {
			
			MongoDatabase dataBase = mongoClient.getDatabase(DATA_BASE);
			
			MongoCollection<Document> collection = dataBase.getCollection(CITY_WEATHER_CONDITIONS_COLLECTION);
			
			Gson gson = new Gson();
			
			Document document = Document.parse(gson.toJson(stationWeather));
			
			collection.insertOne(document);
			
		}
	}
}
