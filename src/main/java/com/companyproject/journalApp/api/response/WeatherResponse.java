package com.companyproject.journalApp.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WeatherResponse {
    private List<Data> data;
    private int count;

    @Getter
    @Setter
    public static class Data {

        @JsonProperty("country_code")
        private String countryCode;

        @JsonProperty("wind_spd")
        private double windSpd;  // Wind Speed

        @JsonProperty("state_code")
        private String stateCode;

        @JsonProperty("city_name")
        private String cityName;

        private double temp;  // Temperature

    }
}
