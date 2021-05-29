package pl.springboot2.karoljanik.weatherforecast.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.springboot2.karoljanik.weatherforecast.model.ConsolidatedWeather;
import pl.springboot2.karoljanik.weatherforecast.model.Parent;
import pl.springboot2.karoljanik.weatherforecast.model.Weather;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    public List<ConsolidatedWeather> getCity(String city) {
        RestTemplate restTemplate = new RestTemplate();
        Parent[] weatherLocalization= restTemplate.getForObject("https://www.metaweather.com/api/location/search/?query="+city, Parent[].class);
        List<Integer> woeid = Arrays.stream(weatherLocalization).map(parent -> parent.getWoeid()).collect(Collectors.toList());
        Weather weatherInfo = restTemplate.getForObject("https://www.metaweather.com/api/location/"+woeid.get(0), Weather.class);
        List<ConsolidatedWeather> weatherList = weatherInfo.getConsolidatedWeather();
        return weatherList;
    }
}
