package intermediate.labTwo.designPatterns.behavioral.observer;

public class CurrentWeatherConditions implements Observer {
    private float temperature;
    private float humidity;
    private float pressure;

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    public void display() {
        System.out.println("Current conditions: " + temperature + "°C degrees and " + humidity + "% humidity");
    }
}
