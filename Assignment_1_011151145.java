import java.util.Scanner;
import java.util.regex.Pattern;

public class Assignment_1_011151145{
    
        public static boolean Password(String password) {
        if (!Pattern.matches("PAS.*", password)) {
            return false;
        }

        if (password.length() <= 10) {
            return false;
        }

        if (!Pattern.matches(".*[@#$%^&+=! ].*", password)) {
            return false;
        }

        for (int i = 0; i < password.length()-1; i++) {
            if (password.charAt(i) == password.charAt(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public static boolean Email(String email) {
        if (Pattern.matches("[a-zA-Z]+@(cse|eee|bba)\\.uiu\\.ac\\.bd", email)) {
            return true;
        }

        return false;
    }

    public static boolean StringQ3(String stringQ3) {
        if (Pattern.matches("[A-Z][a-zA-Z]*[3][0-9]{2}((CSE)|(UIU)|(COM))([+-])?[a-z]?", stringQ3)) {
            return true;
        }
        return false;
    }

    public static boolean StringQ4(String stringQ4) {
        if (Pattern.matches("[@#]([0-9]{3}[a-z]{3}(0|1)[A-Z]{1}[0-9]{3}gmail\\.com)", stringQ4)) {
            return true;
        }
        return false;
    }

    public static boolean StudentID(String studentID) {
        if (Pattern.matches("^(011|111|021)(0[5-9]|1[0-9]|2[0-2])([1-3])(\\d{3})$", studentID)) {
            return true;
        }
        return false;
    }









    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean end = false;

        while (!end) {
            System.out.println("-------------------------------");
            System.out.println("###########  Menu    ##########");
            System.out.println("-------------------------------");
            System.out.println("1. Validate password");
            System.out.println("2. Validate UIU CSE/EEE/BBA faculty email address");
            System.out.println("3. Validate string for question 3");
            System.out.println("4. Validate string for question 4");
            System.out.println("5. Validate UIU student ID");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter password: ");
                    String password = input.nextLine();


                    if (Password(password)) {
                        System.out.println("Password is valid.");
                    } 
                    else {
                        System.out.println("Password is invalid.");
                    }
                    break;


                case 2:
                    System.out.print("Enter a UIU faculty email: ");
                    String email = input.nextLine();


                    if (Email(email)) {
                        System.out.println("Faculty email is valid.");
                    } 
                    
                    else {
                        System.out.println("Faculty email is invalid.");
                    }
                    break;


                case 3:
                    System.out.print("Enter a string: ");
                    String stringQ3 = input.nextLine();
                    if (StringQ3(stringQ3)) {
                        System.out.println("For Q-3, String is valid.");
                    } 
                    else {
                        System.out.println("For Q-3, String is invalid.");
                    }
                    break;
                case 4:
                    System.out.print("Enter a string: ");
                    String stringQ4 = input.nextLine();


                    if (StringQ4(stringQ4)) {
                        System.out.println("For Q-4, String is valid.");
                    } 
                    else {
                        System.out.println("For Q-4, String is invalid.");
                    }
                    break;


                case 5:
                    System.out.print("Enter a UIU student ID: ");
                    String studentID = input.nextLine();

                    if (StudentID(studentID)) {

                        System.out.println("UIU student ID "+studentID+" is valid." );
                    }
                    else {
                        System.out.println("UIU student ID "+studentID+" is invalid.");
                    }
                    break;


                case 6:
                    end = true;
                    input.close();
                    break;


                default:
                    System.out.println("** Choose between 1 to 6 **");
            }
        }

        System.out.println(" Already exist ");
    }

    
}
