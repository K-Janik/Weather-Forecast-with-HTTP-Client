import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../../environments/environment';
import {Observable} from 'rxjs';
import {ConsolidatedWeather} from '../weather/weather';

@Injectable({
  providedIn: 'root'
})
export class WeatherService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getWeather(city: string): Observable<ConsolidatedWeather[]> {
    return this.http.get<ConsolidatedWeather[]>(`${this.apiServerUrl}/weather/${city}`);
  }
}

