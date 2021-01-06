package webservice.service;

import webservice.po.WeatherPo;

public interface WeatherService {

    WeatherPo getWeather(String region);
}
