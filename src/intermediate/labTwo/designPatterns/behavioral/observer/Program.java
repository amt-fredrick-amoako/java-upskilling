package intermediate.labTwo.designPatterns.behavioral.observer;

public class Program {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        CurrentWeatherConditions currentDisplay = new CurrentWeatherConditions();
        DisplayStats statisticsDisplay = new DisplayStats();

        weatherStation.registerObserver(currentDisplay);
        weatherStation.registerObserver(statisticsDisplay);


        // Set measurements in Celsius
        weatherStation.setMeasurements(26.7f, 65, 30.4f);
        weatherStation.setMeasurements(27.8f, 70, 29.2f);


        // After removing Statistics Display, it should no longer receive updates
        weatherStation.removeObserver(statisticsDisplay);
        weatherStation.setMeasurements(25.6f, 90, 29.2f);

    }
}
