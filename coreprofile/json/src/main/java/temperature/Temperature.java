package temperature;

public class Temperature {

    public enum TemperatureScale {
        CELSIUS,
        FAHRENHEIT
    }

    private TemperatureScale scale;

    private double temperature;

    public TemperatureScale getScale() {
        return scale;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setScale(TemperatureScale scale) {
        this.scale = scale;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
