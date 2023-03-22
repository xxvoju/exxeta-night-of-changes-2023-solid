package sk.exxeta.nightofchances.refactored.example3.weather;

public class WeatherTracker {
    private double temperature;
    private Notifier notifier;
    public WeatherTracker(Notifier notifier) {
        this.notifier = notifier;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
        if (temperature <= 0) {
            notifier.generateWeatherAlert(temperature);
        }
    }
}
