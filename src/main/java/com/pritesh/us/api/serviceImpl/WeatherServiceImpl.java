package com.pritesh.us.api.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pritesh.us.api.entity.Weather;
import com.pritesh.us.api.exception.BadRequestException;
import com.pritesh.us.api.respository.WeatherRepository;
import com.pritesh.us.api.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private WeatherRepository weatherRespository;
	
	@Override
	@Transactional(readOnly=true)
	public List<String> findAllCities() {
		return weatherRespository.findAllCities();
	}

	@Override
	@Transactional(readOnly=true)
	public Weather WeatherByCity(String city) {
		Weather existing = weatherRespository.WeatherByCity(city);
		if(existing == null)
		{
			throw new BadRequestException("City with "+city+" name does not exist");
		}
		return existing;
	}

	@Override
	@Transactional(readOnly=true)
	public String weatherByCityByProperty(String city, String property) {
		String existing = weatherRespository.weatherByCityByProperty(city,property);
		if(existing == null)
		{
			throw new BadRequestException("City with "+city+" name does not exist");
		}
		return existing;
	}

	@Override
	@Transactional(readOnly=true)
	public Weather weatherByCityByPropertyDateNTime(String city, String date) {
		Weather existing = weatherRespository.weatherByCityByPropertyDateNTime(city,date);
		if(existing == null)
		{
			throw new BadRequestException("City with "+city+" name does not exist");
		}
		return existing;
	}

	@Override
	@Transactional
	public Weather createWeather(Weather weather) {
		return weatherRespository.createWeather(weather);
	}

	@Transactional(readOnly=true)
	@Override
	public Weather updateWeather(String id, Weather weather) {
		Weather existing = weatherRespository.findOne(id);
		if(existing == null)
		{
			throw new BadRequestException("Weather with "+id+" does not exist");
		}
		return weatherRespository.updateWeather(weather);
	}

	@Override
	@Transactional
	public void deleteWeather(String id) {
		Weather existing = weatherRespository.findOne(id);
		if(existing == null)
		{
			throw new BadRequestException("Weather with "+id+" does not exist");
		}
	
		weatherRespository.deleteWeather(existing);
	}

	@Override
	@Transactional
	public Weather findOne(String id) {
		Weather existing = weatherRespository.findOne(id);
		if(existing == null)
		{
			throw new BadRequestException("Weather with "+id+" does not exist");
		}
		return existing;
	}

}
