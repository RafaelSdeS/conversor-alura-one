import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import converters.CurrencyConverter;
import converters.TemperatureConverter;
import panels.CurrencyConversionPanel;
import panels.TemperatureConversionPanel;

import java.math.BigDecimal;

public class App {

    public static void main(String[] args) {
        boolean continueApp = true;

        while (continueApp) {
            // Define the options
            String[] options = {
                "Conversor de moedas",
                "Conversor de temperatura"
            };

            // Create a combo box with the options
            JComboBox<String> comboBox = new JComboBox<>(options);

            // Create a panel to hold the combo box
            JPanel panel = new JPanel();
            panel.add(comboBox);

            // Display the input dialog with the combo box
            int result = JOptionPane.showConfirmDialog(
                null,                  // Parent component (null for no parent)
                panel,                 // Panel with the combo box
                "Selecione uma Conversão", // Dialog title
                JOptionPane.OK_CANCEL_OPTION, // Option type (OK and Cancel buttons)
                JOptionPane.PLAIN_MESSAGE   // Message type (no icon)
            );

            // Check the user's choice
            if (result == JOptionPane.OK_OPTION) {
                String selectedOption = (String) comboBox.getSelectedItem();

                if (selectedOption.equals("Conversor de moedas")) {
                    // Currency conversion logic
                    CurrencyConversionPanel currencyConversionPanel = new CurrencyConversionPanel();
                    int currencyResult = JOptionPane.showConfirmDialog(
                        null,
                        currencyConversionPanel,
                        "Selecione uma Conversão de Moeda",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE
                    );

                    if (currencyResult == JOptionPane.OK_OPTION) {
                        String selectedCurrencyOption = currencyConversionPanel.getSelectedOption();
                        BigDecimal amountInBRL = currencyConversionPanel.getAmountInBRL();

                        // Perform currency conversion based on the selected option
                        BigDecimal convertedAmount = performCurrencyConversion(selectedCurrencyOption, amountInBRL);

                        // Display the converted amount
                        JOptionPane.showMessageDialog(
                            null,
                            amountInBRL + " BRL is equal to " + convertedAmount + " " + selectedCurrencyOption,
                            "Conversão de Moeda",
                            JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                } else if (selectedOption.equals("Conversor de temperatura")) {
                    // Temperature conversion logic
                    TemperatureConversionPanel temperatureConversionPanel = new TemperatureConversionPanel();
                    int temperatureResult = JOptionPane.showConfirmDialog(
                        null,
                        temperatureConversionPanel,
                        "Selecione uma Conversão de Temperatura",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE
                    );

                    if (temperatureResult == JOptionPane.OK_OPTION) {
                        String selectedTemperatureOption = temperatureConversionPanel.getSelectedOption();
                        BigDecimal temperatureValue = new BigDecimal(temperatureConversionPanel.getTemperatureValue());

                        // Perform temperature conversion based on the selected option
                        BigDecimal convertedTemperature = performTemperatureConversion(selectedTemperatureOption, temperatureValue);

                        // Display the converted temperature
                        JOptionPane.showMessageDialog(
                            null,
                            temperatureValue + " graus é igual a " + convertedTemperature + " " + selectedTemperatureOption,
                            "Conversão de Temperatura",
                            JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
            } else {
                // User closed the dialog or clicked Cancel
                JOptionPane.showMessageDialog(
                    null,
                    "Nenhuma opção selecionada.",
                    "Opção Cancelada",
                    JOptionPane.INFORMATION_MESSAGE
                );
            }

            // Ask the user if they want to use the app again
            int continueChoice = JOptionPane.showConfirmDialog(
                null,
                "Deseja usar o aplicativo novamente?",
                "Continuar?",
                JOptionPane.YES_NO_OPTION
            );

            if (continueChoice != JOptionPane.YES_OPTION) {
                continueApp = false;
            }
        }
    }

    private static BigDecimal performCurrencyConversion(String selectedOption, BigDecimal amountInBRL) {
        if (selectedOption.startsWith("De reais para")) {
            // Convert from Reais to the selected currency
            return CurrencyConverter.convertFromReaisToCurrency(amountInBRL, selectedOption);
        } else if (selectedOption.startsWith("De")) {
            // Convert from the selected currency back to Reais
            return CurrencyConverter.convertToReaisFromCurrency(amountInBRL, selectedOption);
        } else {
            throw new IllegalArgumentException("Invalid currency conversion option");
        }
    }

    private static BigDecimal performTemperatureConversion(String selectedOption, BigDecimal temperatureValue) {
        switch (selectedOption) {
            case "De Celsius para Fahrenheit":
                return TemperatureConverter.celsiusToFahrenheit(temperatureValue);
            case "De Celsius para Kelvin":
                return TemperatureConverter.celsiusToKelvin(temperatureValue);
            case "De Fahrenheit para Celsius":
                return TemperatureConverter.fahrenheitToCelsius(temperatureValue);
            case "De Fahrenheit para Kelvin":
                return TemperatureConverter.fahrenheitToKelvin(temperatureValue);
            default:
                throw new IllegalArgumentException("Invalid temperature conversion option");
        }
    }
    
}
