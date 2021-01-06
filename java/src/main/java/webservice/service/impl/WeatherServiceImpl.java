package webservice.service.impl;


import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import webservice.po.WeatherPo;
import webservice.service.WeatherService;

import javax.jws.WebService;

@WebService
public class WeatherServiceImpl implements WeatherService {
    private static final Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);


    public WeatherPo getWeather(String region) {
        logger.trace("请求天气");
        return new WeatherPo(region, "2-wind", "1-sun", "0-rain", "0-snow", "0");
    }

}
