import { Component, OnInit } from '@angular/core';
import {ConsolidatedWeather} from './weather';
import {WeatherService} from '../services/weather.service';

@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html',
  styleUrls: ['./weather.component.css']
})
export class WeatherComponent implements OnInit {

  city: string;
  consolidatedWeather: ConsolidatedWeather[];

  constructor(private weatherService: WeatherService) { }

  ngOnInit(): void {
  }

  public getCity(value: string): void {
    this.city = value;
    this.weatherService.getWeather(value).subscribe(
         (response: ConsolidatedWeather[]) => {
           this.consolidatedWeather = response;
         }
    );
  }
}
