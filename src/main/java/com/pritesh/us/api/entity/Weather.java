package com.pritesh.us.api.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Weather.findAll", query="SELECT e.city FROM Weather e ORDER BY e.city"),
	@NamedQuery(name = "Weather.findByPropertyAndCity", query="SELECT e FROM Weather e where e.city=:pCity"),
	@NamedQuery(name = "Weather.findByDateAndCity", query="SELECT e FROM Weather e where e.city=:pCity and e.date=:pDate")
})
public class Weather {
	
	public Weather()
	{
		this.weatherid = UUID.randomUUID().toString();
	}
	
	@Id
	private String weatherid;
	private String temperature;
	private String city;
	private String humidity;
	private String wind;
	private String date;
	private String sunrise;
	private String sunset;
	private String windDirection;
	private String feelsLike;
	private String pressure;
	private String visibilty;
	
	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getSunrise() {
		return sunrise;
	}

	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}

	public String getSunset() {
		return sunset;
	}

	public void setSunset(String sunset) {
		this.sunset = sunset;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	public String getFeelsLike() {
		return feelsLike;
	}

	public void setFeelsLike(String feelsLike) {
		this.feelsLike = feelsLike;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getVisibilty() {
		return visibilty;
	}

	public void setVisibilty(String visibilty) {
		this.visibilty = visibilty;
	}

	public String getWeatherid() {
		return weatherid;
	}

	public void setWeatherid(String weatherid) {
		this.weatherid = weatherid;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getWind() {
		return wind;
	}

	public void setWind(String wind) {
		this.wind = wind;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
}
