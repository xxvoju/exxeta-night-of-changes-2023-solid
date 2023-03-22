package sk.exxeta.nightofchances.refactored.example3;

import sk.exxeta.nightofchances.refactored.example3.email.EmailNotifier;
import sk.exxeta.nightofchances.refactored.example3.phone.PhoneNotifier;
import sk.exxeta.nightofchances.refactored.example3.weather.WeatherTracker;

public class Main {
    public void main(String[] args) {
        PhoneNotifier phoneNotifier = new PhoneNotifier();
        EmailNotifier emailNotifier = new EmailNotifier();
        WeatherTracker weatherTracker = new WeatherTracker(phoneNotifier);
        weatherTracker.setTemperature(Math.random());
    }
}
