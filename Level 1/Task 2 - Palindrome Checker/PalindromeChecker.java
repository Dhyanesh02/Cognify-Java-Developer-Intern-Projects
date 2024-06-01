import java.util.Scanner;

public class PalindromeChecker {

  public static boolean isPalindrome(String w) {

    StringBuffer word = new StringBuffer();
    for (char s : w.toCharArray()){
      if(Character.isLetterOrDigit(s)){
      word.append(s);
      }
    }
    String reverse = word.toString().toLowerCase();
    int i = 0, j = word.length() - 1;
    while (i < j) {
      if (reverse.charAt(i) != reverse.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }  
  public static boolean findMore(String choice, boolean conversion) {
    if (choice.equals("no")) {
      conversion = false;
      System.out.println("Thanks for using my Palindrome Checker!");
    }
    return conversion;
  }
  public static void main(String[] args) {
    System.out.println("**-------------------------------------**");
    System.out.println("  Hello! Welcome to Palindrome Checker!");
    System.out.println("**-------------------------------------**");
    Scanner input = new Scanner(System.in);
    boolean condition = true;
    while (condition) {
      System.out.print("Enter a word or phrase: ");
      String word = input.nextLine();
      if (isPalindrome(word))
        System.out.println("Palindrom " + word);
      else
        System.out.println("Not a palindrom");
      System.out.print("To check next word/phrase enter (yes/no): ");
      String choice = input.next().toLowerCase();
      condition = findMore(choice, condition);
      System.out.println("**-------------------------------------**");
    }
    input.close();
  }
}
