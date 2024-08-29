package com.companyproject.journalApp.services;

import com.companyproject.journalApp.api.response.WeatherResponse;
import com.companyproject.journalApp.cache.AppCache;
import com.companyproject.journalApp.contants.Placeholders;
import org.springframework.aop.aspectj.AspectJPrecedenceInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AppCache appCache;

    @Autowired
    private RedisService redisService;


    public  WeatherResponse getWeather(String city){
        WeatherResponse weatherResponse = redisService.get("Weather_of_defaut", WeatherResponse.class);
        System.out.print(weatherResponse);
        if(weatherResponse!=null){
            return weatherResponse;
        }else {
            String finalApi = appCache.appCache.get(AppCache.keys.WEATHER_API.toString()).replace(Placeholders.API_KEY, apiKey);
            System.out.print(finalApi);
            ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);
            WeatherResponse body = response.getBody();
            if(body!=null){
                redisService.set("Weather_of_defaut",body,300l);
            }
            return body;
        }



    }

}






