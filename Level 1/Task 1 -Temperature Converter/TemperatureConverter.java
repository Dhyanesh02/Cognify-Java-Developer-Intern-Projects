import java.util.Scanner;

public class TemperatureConverter {

  public static void convertTemperature(String choice,Double temperature) {

    if (choice.equals("C"))
      System.out.printf("Celsius to Fahrenheit: %.2f °F%n", celsiusToFahrenheit(temperature));
    else if (choice.equals("F"))
      System.out.printf("Fahrenheit to Celsius: %.2f°C%n", fahrenheitCelsiusTo(temperature));
    else
      System.out.println("Invalid unit of measurement. Please enter 'C' for Celsius or 'F' for Fahrenheit.");
  }

  public static double celsiusToFahrenheit(double celsius) {
    return (celsius * 9 / 5 + 32);
  }

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

    System.out.println("Welcome to Temperature Converter!");
    Scanner input = new Scanner(System.in);

    boolean conversion = true;

    while (conversion) {

      System.out.println("'C' for Celsius to Fahrenheit.");
      System.out.println("'F' for Fahrenheit to Celsius.");
      System.out.print("Enter your choice ('C' or'F'): ");
      String choice = input.next().toUpperCase();


      System.out.print("Enter Temperature Value: ");
      double temperature = input.nextDouble();

      convertTemperature(choice, temperature);

      System.out.print("To find more value enter (yes/no) :");
      String run = input.next().toLowerCase();
      conversion = findMore(run, conversion);
    }
    input.close();
  }
}