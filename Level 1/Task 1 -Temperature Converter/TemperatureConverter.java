import java.util.Scanner;

public class TemperatureConverter {

  public static void convertTemperature(String choice,Double temperature) {
    // Perform the conversion based on user's choice and display the result
    if (choice.equals("C"))
      System.out.printf("Celsius to Fahrenheit: %.2f °F%n", celsiusToFahrenheit(temperature));
    else if (choice.equals("F"))
      System.out.printf("Fahrenheit to Celsius: %.2f°C%n", fahrenheitCelsiusTo(temperature));
    else
      System.out.println("Invalid unit of measurement. Please enter 'C' for Celsius or 'F' for Fahrenheit.");
  }

  // Method to Convert Celsius to Fahrenheit
  public static double celsiusToFahrenheit(double celsius) {
    return (celsius * 9 / 5 + 32);
  }
  // Method to Convert Fahrenheit to Celsius
  public static double fahrenheitCelsiusTo(double fahrenheit) {
    return ((fahrenheit - 32) * 5 / 9);
  }

  public static boolean findMore(String choice, boolean conversion) {
    if (choice.equals("no")) {       
      conversion = false;
      System.out.println("Thanks for using my Temperature Converter!");
    }
    return conversion;
  }

  public static void main(String[] args) {
    //Scanner object for user input
    System.out.println("Welcome to Temperature Converter!");
    Scanner input = new Scanner(System.in);
    // Flag to control the while loop for multiple conversions
    boolean conversion = true;

    while (conversion) {
      // Read the user's choice and convert to uppercase
      System.out.println("'C' for Celsius to Fahrenheit.");
      System.out.println("'F' for Fahrenheit to Celsius.");
      System.out.print("Enter your choice ('C' or'F'): ");
      String choice = input.next().toUpperCase();

      // Prompt the user to enter the temperature value
      System.out.print("Enter Temperature Value: ");
      double temperature = input.nextDouble();
      // Perform the temperature conversion based on the user's choice
      convertTemperature(choice, temperature);
      // Ask the user if they want to perform another conversion
      System.out.print("To find more value enter (yes/no) :");
      String run = input.next().toLowerCase();
      conversion = findMore(run, conversion);
    }
    input.close();
  }
}