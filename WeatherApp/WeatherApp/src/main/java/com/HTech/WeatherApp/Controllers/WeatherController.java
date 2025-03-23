package com.HTech.WeatherApp.Controllers;

import com.HTech.WeatherApp.Responses.WeatherResponse;
import com.HTech.WeatherApp.Services.SendEmail;
import com.HTech.WeatherApp.Services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Weather")
public class WeatherController {
    @Autowired
    WeatherService weatherService;
    @Autowired
    SendEmail sendEmail;
    @GetMapping
    public ResponseEntity<?> GetWeather(){
        WeatherResponse weatherResponse=weatherService.getWeatherByCity("Mumbai");
        String Weather_Body= "Weather Details:\n\n" + weatherResponse.toString();
        sendEmail.sendEmail("harshmeshramoffic27@gmail.com",
                "Java Email Sender ",
                Weather_Body);
//        if(weatherResponse != null){
            return new ResponseEntity<>(weatherResponse,HttpStatus.OK);
//        }
//        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
