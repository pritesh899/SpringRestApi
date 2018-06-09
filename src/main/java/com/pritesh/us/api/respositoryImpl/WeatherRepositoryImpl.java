package com.pritesh.us.api.respositoryImpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.pritesh.us.api.entity.Weather;
import com.pritesh.us.api.respository.WeatherRepository;

@Repository
public class WeatherRepositoryImpl implements WeatherRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<String> findAllCities() {
		TypedQuery<String> query = em.createNamedQuery("Weather.findAll", String.class);
		return query.getResultList();
	}

	@Override
	public Weather WeatherByCity(String city) {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findByPropertyAndCity", Weather.class);
		query.setParameter("pCity", city);
		List<Weather> propertys = query.getResultList();
		Weather cityWeather = propertys.get(0); 
		return cityWeather;
		
	}

	@Override
	public String weatherByCityByProperty(String city, String property) {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findByPropertyAndCity", Weather.class);
		query.setParameter("pCity", city);
		
		List<Weather> propertys = query.getResultList();

		if(!propertys.isEmpty())
		{
			if (property.equals("wind"))
			{
				String wind = propertys.get(0).getWind() + " "+ propertys.get(0).getWindDirection() ; 
				return  wind;
			}
			else if (property.equals("humidity"))
			{
				String humidity = propertys.get(0).getHumidity(); 
				return humidity;
			}

			else if (property.equals("temperature"))
			{
				String temperature = propertys.get(0).getTemperature(); 
				return temperature;
			}
			else if (property.equals("sunrise"))
			{
				String sunrise = propertys.get(0).getSunrise(); 
				return sunrise;
			}
			else if (property.equals("sunset"))
			{
				String sunset = propertys.get(0).getSunset(); 
				return sunset;
			}
			else if (property.equals("pressure"))
			{
				String pressure = propertys.get(0).getPressure(); 
				return pressure;
			}
			else if (property.equals("visibility"))
			{
				String visibility = propertys.get(0).getVisibilty(); 
				return visibility;
			}
			else if (property.equals("feelsLike"))
			{
				String feelsLike = propertys.get(0).getFeelsLike(); 
				return feelsLike;
			}
			
		}
		return " No Valid Data Found For City "; 
	}

	@Override
	public Weather weatherByCityByPropertyDateNTime(String city, String date) {
		
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findByDateAndCity", Weather.class);
		query.setParameter("pCity", city);
		query.setParameter("pDate", date);
		List<Weather> weathers = query.getResultList();
		
		if(!weathers.isEmpty())
		{
			return weathers.get(0);
		}else{
			return null;
		}
	}
	
	@Override
	public Weather findOne(String id) {
		return em.find(Weather.class, id);
	}


	@Override
	public Weather createWeather(Weather weather) {
		em.persist(weather);
		return weather;
	}

	
	@Override
	public Weather updateWeather(Weather weather) {
		return em.merge(weather);
	}

	@Override
	public void deleteWeather(Weather weather) {
		em.remove(weather);
		
	}

}
