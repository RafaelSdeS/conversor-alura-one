package panels;
// TemperatureConversionPanel.java (in the gui package)
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TemperatureConversionPanel extends JPanel {

    private JComboBox<String> temperatureComboBox;
    private JTextField temperatureValueField;

    public TemperatureConversionPanel() {
        // Define the temperature conversion options
        String[] temperatureConversionOptions = {
            "De Celsius para Fahrenheit",
            "De Celsius para Kelvin",
            "De Fahrenheit para Celsius",
            "De Fahrenheit para Kelvin"
        };

        // Create a combo box with the options
        temperatureComboBox = new JComboBox<>(temperatureConversionOptions);

        // Create an input field for the temperature value
        temperatureValueField = new JTextField(10);

        // Add components to this panel
        this.add(new JLabel("Valor da Temperatura:")); // Label for the input field
        this.add(temperatureValueField);
        this.add(temperatureComboBox);
    }

    public String getSelectedOption() {
        return (String) temperatureComboBox.getSelectedItem();
    }

    public double getTemperatureValue() {
        String temperatureText = temperatureValueField.getText();
        try {
            return Double.parseDouble(temperatureText);
        } catch (NumberFormatException e) {
            // Handle parsing error (e.g., display a message to the user)
            throw new IllegalArgumentException("Invalid temperature value format");
        }
    }
}
