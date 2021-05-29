package pl.springboot2.karoljanik.weatherforecast.controller;

import org.springframework.web.bind.annotation.*;
import pl.springboot2.karoljanik.weatherforecast.model.ConsolidatedWeather;
import pl.springboot2.karoljanik.weatherforecast.service.WeatherService;

import java.util.List;

@RestController
@RequestMapping("/weather")
@CrossOrigin(origins = "http://localhost:4200")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping(path = "/{city}")
    public List<ConsolidatedWeather> getCity(@PathVariable("city") String city) {
        return weatherService.getCity(city);
    }
}
