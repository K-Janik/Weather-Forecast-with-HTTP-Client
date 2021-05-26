package pl.springboot2.karoljanik.weatherforecast.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.springboot2.karoljanik.weatherforecast.model.Parent;
import pl.springboot2.karoljanik.weatherforecast.model.Weather;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    public List<Weather> getCity() {
        RestTemplate restTemplate = new RestTemplate();
//        Tutaj podaję nazwę miasta, dzięki czemu pobieram reprezentujący je numer
//        Weather[] weatherLocalization= restTemplate.getForObject("https://www.metaweather.com/api/location/search/?query="+city, Weather[].class);
//        Tutaj chciałbym wyciągnąć z weatherLocalization woeid, żebym mogł go przekazać w kolejnym linku
//        Weather woeid = x -> Arrays.stream(weatherLocalization).findFirst()
        Weather[] weatherInfo = restTemplate.getForObject("https://www.metaweather.com/api/location/523920", Weather[].class);
        List<Weather> weatherList = Arrays.stream(weatherInfo).collect(Collectors.toList());
        return weatherList;
    }
}
