package sk.exxeta.nightofchances.refactored.example3.phone;

import sk.exxeta.nightofchances.refactored.example3.weather.Notifier;

public class PhoneNotifier implements Notifier {
    public String generateWeatherAlert(double weatherConditions) {
        /**/
        return "The temperature is: " + weatherConditions;
    }
}
