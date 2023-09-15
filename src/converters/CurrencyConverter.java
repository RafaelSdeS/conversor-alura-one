package converters;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CurrencyConverter {

    private static final BigDecimal USD_RATE = new BigDecimal("0.19"); // 1 BRL to USD
    private static final BigDecimal GBP_RATE = new BigDecimal("0.14"); // 1 BRL to GBP
    private static final BigDecimal EUR_RATE = new BigDecimal("0.16"); // 1 BRL to EUR

    public static BigDecimal convertFromReaisToCurrency(BigDecimal amount, String currencyOption) {
        switch (currencyOption) {
            case "De reais para dólar":
                return amount.multiply(USD_RATE).setScale(2, RoundingMode.HALF_UP);
            case "De reais para euro":
                return amount.multiply(EUR_RATE).setScale(2, RoundingMode.HALF_UP);
            case "De reais para libra":
                return amount.multiply(GBP_RATE).setScale(2, RoundingMode.HALF_UP);
            default:
                throw new IllegalArgumentException("Invalid currency conversion option");
        }
    }

    public static BigDecimal convertToReaisFromCurrency(BigDecimal amount, String currencyOption) {
        switch (currencyOption) {
            case "De dólar para reais":
                return amount.divide(USD_RATE, 2, RoundingMode.HALF_UP);
            case "De euro para reais":
                return amount.divide(EUR_RATE, 2, RoundingMode.HALF_UP);
            case "De libra para reais":
                return amount.divide(GBP_RATE, 2, RoundingMode.HALF_UP);
            default:
                throw new IllegalArgumentException("Invalid currency conversion option");
        }
    }
}
