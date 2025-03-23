package com.HTech.WeatherApp.Responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class WeatherResponse {

    private Request request;
    private Location location;
    private Current current;

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }

    public class Request {
        @JsonProperty("type")
        private String Type;
        @JsonProperty("query")
        private String Query;
        @JsonProperty("language")
        private String Language;

        public String getType() {
            return Type;
        }

        public void setType(String type) {
            Type = type;
        }

        public String getQuery() {
            return Query;
        }

        public void setQuery(String query) {
            Query = query;
        }

        public String getLanguage() {
            return Language;
        }

        public void setLanguage(String language) {
            Language = language;
        }
    }
    public class Location {
        @JsonProperty("name")
        private String Name;
        @JsonProperty("localtime")
        private String localTime;

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getLocalTime() {
            return localTime;
        }

        public void setLocalTime(String localTime) {
            this.localTime = localTime;
        }
    }

    public class Current {
        @JsonProperty("observation_time")
        private String observationTime;
        @JsonProperty("temperature")
        private int Temperature;
        @JsonProperty("weather_descriptions")
        private List<String> weatherDescriptions;
        @JsonProperty("feelslike")
        private int feelsLike;

        public String getObservationTime() {
            return observationTime;
        }

        public void setObservationTime(String observationTime) {
            this.observationTime = observationTime;
        }

        public int getTemperature() {
            return Temperature;
        }

        public void setTemperature(int temperature) {
            Temperature = temperature;
        }

        public List<String> getWeatherDescriptions() {
            return weatherDescriptions;
        }

        public void setWeatherDescriptions(List<String> weatherDescriptions) {
            this.weatherDescriptions = weatherDescriptions;
        }

        public int getFeelsLike() {
            return feelsLike;
        }

        public void setFeelsLike(int feelsLike) {
            this.feelsLike = feelsLike;
        }
    }
}
