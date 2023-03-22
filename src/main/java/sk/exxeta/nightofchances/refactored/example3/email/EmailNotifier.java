package sk.exxeta.nightofchances.refactored.example3.email;

import sk.exxeta.nightofchances.refactored.example3.weather.Notifier;

public class EmailNotifier implements Notifier {
    public String generateWeatherAlert(double weatherConditions) {
        /**/
        return "The temperature is: " + weatherConditions;
    }
}
