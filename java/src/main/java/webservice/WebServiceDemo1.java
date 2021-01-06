package webservice;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import webservice.service.impl.WeatherServiceImpl;

import javax.xml.ws.Endpoint;

public class WebServiceDemo1 {
    private static final Logger logger = LoggerFactory.getLogger(WebServiceDemo1.class);
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9001/Service/Function",new WeatherServiceImpl());

    }
}
