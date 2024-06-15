import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordStrengthChecker {
  private static boolean toBeContinue(String userChoice, boolean continueChecking) {
    if (userChoice.equals("no")) {
      continueChecking = false;
      System.out.println("Thanks for visiting Password Strength Checker.");
    } else if (!userChoice.equals("yes")) {
      continueChecking = false;
      System.out.println("Invalid input. Goodbye!, Thanks for visiting Password Strength Checker.");
    }
    return continueChecking;
  }
  private static String checkPasswordStrength(String password) {
        int length = password.length();
        boolean hasUpper = Pattern.compile("[A-Z]").matcher(password).find();
        boolean hasLower = Pattern.compile("[a-z]").matcher(password).find();
        boolean hasDigit = Pattern.compile("[0-9]").matcher(password).find();
        boolean hasSpecial = Pattern.compile("[!@#$%^&*]").matcher(password).find();

        // Check the criteria and assign strength
        if (length < 8) {
            return "Very Weak (Password should be at least 8 characters long)";
        } else if (!hasUpper || !hasLower || !hasDigit || !hasSpecial) {
            return "Weak (Password should contain uppercase letters, lowercase letters, numbers, and special characters)";
        } else if (length >= 8 && hasUpper && hasLower && hasDigit && hasSpecial) {
            return "Strong";
        } else {
            return "Medium";
        }
    }
  public static void main(String[] args) {
     System.out.println("##################### Welcome to Password Strength Checker #####################");
        Scanner userInput = new Scanner(System.in);
        boolean continueChecking = true;

        while (continueChecking) {
            System.out.print("Enter your password: ");
            String password = userInput.next();

            String strengthFeedback = checkPasswordStrength(password);
            System.out.print("Password Strength: \n\t" + strengthFeedback);
            System.out.println("\n--------------------------------------------");
            System.out.print("\nDo you want to continue? (yes/no): ");
            String userChoice = userInput.next().toLowerCase();

            continueChecking = toBeContinue(userChoice, continueChecking);
        }
        userInput.close();
  }
}