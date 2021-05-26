package pl.springboot2.karoljanik.weatherforecast.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.springboot2.karoljanik.weatherforecast.model.Parent;
import pl.springboot2.karoljanik.weatherforecast.model.Weather;
import pl.springboot2.karoljanik.weatherforecast.service.WeatherService;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping()
    public List<Weather> getCity() {
        return weatherService.getCity();
    }
}
