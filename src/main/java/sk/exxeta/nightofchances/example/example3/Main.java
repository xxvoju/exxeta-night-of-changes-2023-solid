package sk.exxeta.nightofchances.example.example3;

import sk.exxeta.nightofchances.example.example3.weather.WeatherTracker;

public class Main {
    public void main(String[] args) {
        WeatherTracker weatherTracker = new WeatherTracker();
        weatherTracker.setTemperature(Math.random());
    }
}
