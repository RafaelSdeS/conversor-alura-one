package panels;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.math.BigDecimal;

public class CurrencyConversionPanel extends JPanel {

    private JComboBox<String> currencyComboBox;
    private JTextField amountField;

    public CurrencyConversionPanel() {
        // Define the currency conversion options
        String[] currencyConversionOptions = {
            "De reais para dólar",
            "De reais para euro",
            "De reais para libra",
            "De dólar para reais",
            "De euro para reais",
            "De libra para reais"
        };

        // Create a combo box with the options
        currencyComboBox = new JComboBox<>(currencyConversionOptions);

        // Create an input field for the amount
        amountField = new JTextField(10);

        // Add components to this panel
        this.add(new JLabel("Valor em BRL:")); // Label for the input field
        this.add(amountField);
        this.add(currencyComboBox);
    }

    public String getSelectedOption() {
        String selectedCurrencyOption = (String) currencyComboBox.getSelectedItem();
        return selectedCurrencyOption;
    }

    public BigDecimal getAmountInBRL() {
        String amountText = amountField.getText();
        // Parse the amount as BigDecimal and handle any parsing errors
        try {
            return new BigDecimal(amountText);
        } catch (NumberFormatException e) {
            // Handle parsing error (e.g., display a message to the user)
            throw new IllegalArgumentException("Invalid amount format");
        }
    }
}
