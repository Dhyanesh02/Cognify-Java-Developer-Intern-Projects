import java.security.SecureRandom;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PasswordGenerator {
  public static String generatePassword(int lengthOfPassword, String numbers, String lowercase, String uppercase,String specialCharacter) {
    String number = "0123456789";
    String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
    String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String specialCharacters = "!@#$%^&*()_+-={}[]|;:'\".,<>?`~";

    StringBuilder characters = new StringBuilder();

    if(numbers.equals("yes")) characters.append(number);
    if(lowercase.equals("yes")) characters.append(lowerCaseLetters);
    if(uppercase.equals("yes")) characters.append(upperCaseLetters);
    if(specialCharacter.equals("yes")) characters.append(specialCharacters);
    if(characters.isEmpty()) {
      System.out.println("One character type should be selected");
      return "null";
    }
    StringBuilder password = new StringBuilder(lengthOfPassword);
    SecureRandom random = new SecureRandom();
    for (int i = 0; i < lengthOfPassword; i++) {
      int index = random.nextInt(characters.length());
      password.append(characters.charAt(index));
    }
    return password.toString();
  }
  public static boolean continuePasswordGenerator(String continuePassword,boolean generatePassword){
    if(continuePassword.equals("yes")) generatePassword = true;
    else {
      generatePassword = false;
      System.out.println("Thank you for using the password generator. Goodbye!");
    }
    return generatePassword;
  }
  public static void main(String[] args) {

    System.out.println("***************************Welcome to Password Generator!***************************");
    Scanner input = new Scanner(System.in);

    boolean generatePassword = true;

    while (generatePassword) {

      try {
        System.out.print("Enter the desired length of the password: ");
        int lengthOfPassword = input.nextInt();

        System.out.print("Include numbers? (yes/no): ");
        String numbers = input.next().toLowerCase();

        System.out.print("Include lowercase letters? (yes/no):");
        String lowercase = input.next().toLowerCase();

        System.out.print("Include uppercase letters? (yes/no):");
        String uppercase = input.next().toLowerCase();

        System.out.print("Include special characters? (yes/no): ");
        String specialCharacters = input.next().toLowerCase();

        String password = generatePassword(lengthOfPassword, numbers, lowercase, uppercase,specialCharacters);
        System.out.println("*******************");
        System.out.println("Generated Password: " + password);
        System.out.println("*******************");
        System.out.print("Generate another password? (yes/no):");
        String continuePassword = input.next().toLowerCase();
        generatePassword = continuePasswordGenerator(continuePassword, generatePassword);
        System.out.println("*********************************************************************************");

      } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter correct values.");
        input.next();
      }
    }
    input.close();
  }
}