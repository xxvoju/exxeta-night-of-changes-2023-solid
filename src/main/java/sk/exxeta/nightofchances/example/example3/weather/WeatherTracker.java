package sk.exxeta.nightofchances.example.example3.weather;

import sk.exxeta.nightofchances.example.example3.email.EmailNotifier;

public class WeatherTracker {
    private double temperature;
//    private PhoneNotifier phoneNotifier;
    private EmailNotifier emailNotifier;

    public WeatherTracker() {
//        phoneNotifier = new PhoneNotifier();
        emailNotifier = new EmailNotifier();
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        if (temperature <= 0) {
//            phoneNotifier.generateWeatherAlert(temperature);
            emailNotifier.generateWeatherAlert(temperature);
        }
    }
}
