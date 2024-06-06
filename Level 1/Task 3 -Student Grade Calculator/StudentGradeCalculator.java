import java.util.Scanner;

public class StudentGradeCalculator {
  public static int[] getEachGrade(Scanner input, int noOfGrades) {
    int grades[] = new int[noOfGrades];
    for (int i = 0; i < noOfGrades; i++) {
      System.out.print("Enter Grade " + (i + 1) + " : ");
      int grade = input.nextInt();
      grades[i] = grade;
    }
    return grades;
  }

  public static int gettotalGrades(int[] grades) {
    int totalGrade = 0;
    for (int i = 0; i < grades.length; i++) {
      totalGrade += grades[i];
    }
    return totalGrade;
  }

  public static double getAverage(int totalGrade, int noOfGrades) {
    return (double) totalGrade / noOfGrades;
  }

  public static boolean continueCalculation(String choice, boolean continueGrade) {
    if (choice.equals("no")) {
      continueGrade = false;
      System.out.println("Thanks for using Student Grade Calculator!!");
      System.out.println("*****************************************************************");
    }
    return continueGrade;
  }
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    System.out.println("*******************Welcome to Grade Calculator*******************");
    boolean continueGrade = true;
    while (continueGrade) {
      System.out.print("Enter No.of Grades: ");
      int noOfGrades = input.nextInt();
      if (noOfGrades <= 0) {
        System.out.println("Enter valid positive grade!!!");
        continue;
      }
      int grades[] = getEachGrade(input, noOfGrades);

      int totalGrade = gettotalGrades(grades);
      System.out.println("Total of Grades: " + totalGrade);
      double averageGrade = getAverage(totalGrade, noOfGrades);
      System.out.println("Average of the grades: " + averageGrade);

      System.out.print("Do you want to calculate grade for another student (yes/no): ");
      String choice = input.next().toLowerCase();
      System.out.println("*****************************************************************");
      continueGrade= continueCalculation(choice,continueGrade);
    }
    input.close();
  }
}
