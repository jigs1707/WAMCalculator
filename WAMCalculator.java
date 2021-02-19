

import java.util.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;


/**
 *
 * @author jigssharma
 */
public class WAMCalculator {

    static ArrayList<Subject> subject = new ArrayList<Subject>();
    static Subject[] subjectArray = subject.toArray(new Subject[0]);

    static Scanner sc = new Scanner(System.in);

    static String line;
    static String[] lineVector;

    

    public static void main(String[] args) {

        
        System.out.println("Please enter the number according to the options");
        System.out.println("1. Enter WAM details");
        System.out.println("2. Quit Application");

        applicationStart();
  
    }
	
	
	
	

    public static void applicationStart() 
{
        int menuOption = sc.nextInt();

        switch (menuOption) {
            case 0:
                System.out.println("If the details entered are correct then press 3 to calculate your WAM, otherwise press 1 to edit list or 2 to quit Application");

                System.out.println();

                int step1 = sc.nextInt();

                switch (step1) {
                    case 1:
                        secondMenuOption();
                        break;

                    case 2:
                        System.out.println("Thank you for using this Application!");
                        System.exit(0);
                        break;

                    case 3:
                        calculateWAM();
                        
                        System.out.println();
                        
                                System.out.println("Please enter the number according to the options");
        System.out.println("1. Enter WAM details");
        System.out.println("2. Quit Application");
        
        applicationStart();
                        break;
                }

                break;

            case 1:
                menuOption1();
               

                System.out.println("If the details entered are correct then press 3 to calculate your WAM, otherwise press 1 to edit list or 2 to quit Application");

                System.out.println();

                int step2 = sc.nextInt();

                switch (step2) {
                    case 1:
                        secondMenuOption();
                        break;

                    case 2:
                        System.out.println("Thank you for using this Application!");
                        System.exit(0);
                        break;

                    case 3:
                        calculateWAM();
                        
                        System.out.println();
                                                        System.out.println("Please enter the number according to the options");
        System.out.println("1. Enter WAM details");
        System.out.println("2. Quit Application");
        
        applicationStart();
                        break;
                }

                break;

            case 2:
                System.out.println("Thank you for using this Application!");
                System.exit(0);
                break;
        }
    }

    public static void calculateWAM() {
        double WAM = 0;

        double numerator = 0;

        double denominator = 0;

        for (Subject a : subject) {
            numerator += (a.getCreditPoints() * a.getSubjectScore());

            denominator = denominator + a.getCreditPoints();
        }

        WAM = numerator / denominator;
        System.out.printf("Your current WAM is: %.2f", WAM);

    }

    public static void createSubject(String name, int score, int points) {
        Subject sub = new Subject(name, score, points);

        subject.add(sub);

    }

    public static void menuOption1() {

        System.out.println("How many subjects will you be entering?");

        int subjectAmount = sc.nextInt();

        System.out.println();

        if (subjectAmount != 0) {
            System.out.println("In order, please enter the subject code, credit points for the subject, and the subject score.");
            System.out.println("Each subject's details must be seperated by a dash. E.g. PSYCH101 - 6 - 75");
            System.out.println();

            for (int i = 1; i <= subjectAmount; i++) {

                System.out.print(i + ". ");
                line = sc.next();

                lineVector = line.split("-");

                

                createSubject(lineVector[0], Integer.parseInt(lineVector[1]), Integer.parseInt(lineVector[2]));
            }

            System.out.println();

            System.out.println("Below are the details you have entered:");
            System.out.println();

            System.out.println("Subject Code " + "Credit Points " + "Subject Score");
            System.out.println("________________________________________");
            System.out.println();

             for (Subject x : subject) {
                System.out.printf("%7s %11s %14s \n", x.getSubjectName().toUpperCase(), x.getCreditPoints(), x.getSubjectScore());
              
                //System.out.println();
                }


        }

    }

    public static void secondMenuOption() {
        int editNumber;
        subjectArray = subject.toArray(subjectArray);

        System.out.println("Enter 1 to edit, 2 to add, 3 to remove a subject from the list, or 0 to go back to main menu");

        int editList = sc.nextInt();

        switch (editList) {
            case 0:
                System.out.println("Press 0 to confirm to go back to main menu, otherwise press 1 to edit list again");

                int editList2 = sc.nextInt();

                switch (editList2) {
                    case 0:
                        System.out.println("Below are the details you have entered:");
                        System.out.println();

                        System.out.println("Subject Code " + "Credit Points " + "Subject Score");
                        System.out.println("________________________________________");
                        System.out.println();

                        for (Subject x : subjectArray) {
                            System.out.printf("%7s %11s %14s \n", x.getSubjectName().toUpperCase(), x.getCreditPoints(), x.getSubjectScore());

                        }

                        System.out.println("Enter 0 to present main menu");
                        applicationStart();
                        break;

                    case 1:
                        secondMenuOption();
                        break;
                }

            case 1:
                System.out.println("Please enter the number of the subject that you would like to edit from the list: ");

          

                int i = 0;
                for (Subject b : subject) {
                    i += 1;

                    System.out.printf("%d. %s\n", i, b.toString());
                  

                }
				
				subjectArray = subject.toArray(subjectArray);

                editNumber = sc.nextInt();

                for (int a = 0; a <= subjectArray.length; a++) {
                    if ((editNumber - 1) == a) {
                        System.out.println("Please enter the new details of the subject in order of subject code, credit points, and subject score");
                        System.out.println("Each subject's details must be seperated by a dash. E.g. PSYCH101-6-75");
                        System.out.println();

                        line = sc.next();

                        lineVector = line.split("-");

                        subject.remove((editNumber - 1));
                        createSubject(lineVector[0], Integer.parseInt(lineVector[1]), Integer.parseInt(lineVector[2]));

                        subjectArray = subject.toArray(subjectArray);

                        System.out.println("Below are the details you have entered:");
                        System.out.println();

                        System.out.println("Subject Code " + "Credit Points " + "Subject Score");
                        System.out.println("________________________________________");
                        System.out.println();

                        for (Subject x : subjectArray) {
                            System.out.printf("%7s %11s %14s \n", x.getSubjectName().toUpperCase(), x.getCreditPoints(), x.getSubjectScore());

                        }
                    }

                }

                System.out.println();

                System.out.println("Enter 0 to go back to the main menu");
                applicationStart();

                break;

            case 2:

                System.out.println("In order, please enter the subject code, credit points for the subject, and the subject score.");
                System.out.println("Each subject's details must be seperated by a dash. E.g. PSYCH101 - 6 - 75");
                System.out.println();

                line = sc.next();

                lineVector = line.split("-");

                createSubject(lineVector[0], Integer.parseInt(lineVector[1]), Integer.parseInt(lineVector[2]));

                System.out.println();

                System.out.println("Below are the details you have entered:");
                System.out.println();

                System.out.println("Subject Code " + "Credit Points " + "Subject Score");
                System.out.println("________________________________________");
                System.out.println();

                for (Subject x : subject) {
                    System.out.printf("%7s %11s %14s \n", x.getSubjectName().toUpperCase(), x.getCreditPoints(), x.getSubjectScore());
                }

                System.out.println();

                System.out.println("Enter 0 to go back to the main menu");
                applicationStart();

                break;

            case 3:

                System.out.println("Please enter the number of the subject that you would like to remove from the list: ");

                int x = 0;
                for (Subject b : subject) {
                    x += 1;

                    System.out.printf("%d. %s\n", x, b.toString());
                   

                }

                editNumber = sc.nextInt();

                subject.remove((editNumber - 1));

                //subjectArray = subject.toArray(subjectArray);

                System.out.println("Below are the details you have entered:");
                System.out.println();

                System.out.println("Subject Code " + "Credit Points " + "Subject Score");
                System.out.println("________________________________________");
                System.out.println();

                for (Subject sub : subject) 
                {
                    System.out.printf("%7s %11s %14s \n", sub.getSubjectName().toUpperCase(), sub.getCreditPoints(), sub.getSubjectScore());

                }

                System.out.println();

                System.out.println("Enter 0 to go back to the main menu");
                applicationStart();

                break;

        }

    }


}















class Subject {

    private String subjectName;
    private int subjectScore;
    private int creditPoints;
    private ArrayList<Subject> subject;

    public Subject(String subjectName, int creditPoints, int subjectScore) {
        this.subjectName = subjectName;
        this.subjectScore = subjectScore;
        this.creditPoints = creditPoints;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public void setSubjectScore(int subjectScore) {
        this.subjectScore = subjectScore;
    }

    public void setCreditPoints(int creditPoints) {
        this.creditPoints = creditPoints;
    }

    public ArrayList<Subject> getArrayList() {
        return subject;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getSubjectScore() {
        return subjectScore;
    }

    public int getCreditPoints() {
        return creditPoints;
    }

    public String toString() {
        return subjectName + " - " + creditPoints + " - " + subjectScore;
    }
}
