package com.HTech.WeatherApp.Services;

import com.HTech.WeatherApp.Responses.WeatherResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    // Constructor to inject the RestTemplate built by RestTemplateBuilder
    public WeatherService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    private static final String API_KEY = "8a9f4708cc550ead86e5452639b3b1ea";
    private static final String API_URL = "https://api.weatherstack.com/current?access_key={apiKey}&query={city}";

    public WeatherResponse getWeatherByCity(String city) {
        // Use RestTemplate's URI variable substitution to construct the final URL
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(
                API_URL,
                HttpMethod.GET,
                null,
                WeatherResponse.class,
                API_KEY,
                city
        );
        return response.getBody();
    } 
}
