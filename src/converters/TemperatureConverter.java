package converters;

import java.math.BigDecimal;
import java.math.MathContext;

public class TemperatureConverter {

    public static BigDecimal celsiusToFahrenheit(BigDecimal celsius) {
        BigDecimal fahrenheit = celsius.multiply(new BigDecimal("9"))
                                        .divide(new BigDecimal("5"), MathContext.DECIMAL128)
                                        .add(new BigDecimal("32"));
        return fahrenheit;
    }

    public static BigDecimal celsiusToKelvin(BigDecimal celsius) {
        BigDecimal kelvin = celsius.add(new BigDecimal("273.15"));
        return kelvin;
    }

    public static BigDecimal fahrenheitToCelsius(BigDecimal fahrenheit) {
        BigDecimal celsius = fahrenheit.subtract(new BigDecimal("32"))
                                        .divide(new BigDecimal("1.8"), MathContext.DECIMAL128);
        return celsius;
    }

    public static BigDecimal fahrenheitToKelvin(BigDecimal fahrenheit) {
        BigDecimal celsius = fahrenheitToCelsius(fahrenheit);
        BigDecimal kelvin = celsiusToKelvin(celsius);
        return kelvin;
    }
}
