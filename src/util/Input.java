package src.util;

import java.util.Scanner;

public class Input {

    private Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public String getString() {
        return this.scanner.nextLine();
    }

    public String getString(String prompt) {
        System.out.println(prompt);
        return this.getString();
    }


//    public boolean yesNo() {
//        String userInput = scanner.nextLine();
//        if (userInput.startsWith("y") || userInput.startsWith("Y")) {
//            System.out.println("Yes");
//            return true;
//        } else {
//            System.out.println("No");
//            return false;
//        }
//    }
// // CLASS WALK THRU
    public boolean yesNo() {
        boolean isYes;
        return isYes = this.getString().trim().toLowerCase().startsWith("y");
    }
//    // .startsWith() is a String method that returns a boolean.

//    //BONUS: ACCEPT PROMPT AS ARGUMENT
public boolean yesNo(String prompt) {
    System.out.println(prompt);
    boolean isYes;
    return isYes = this.getString().trim().toLowerCase().startsWith("y");
}


//    public int getInt() {
//        int userIntInput = scanner.nextInt();
//        return userIntInput;
//    }

//    // CLASS WALK THRU
    public int getInt() {
        try {
            return Integer.parseInt(this.getString());
        } catch (NumberFormatException e) {
            System.out.println("You must enter a whole number.");
//            // recursion! like a loop. will try to get the input again. and if it is able to be parsed, will return the number.
            return this.getInt();
        }
    }

//    //BONUS: PROMPT AS ARGUMENT
    public int getInt(String prompt) {
        System.out.println(prompt);
        try {
            return Integer.parseInt(this.getString());
        } catch (NumberFormatException e) {
            System.out.println("You must enter a whole number.");
//            // recursion! like a loop. will try to get the input again. and if it is able to be parsed, will return the number.
            return this.getInt();
        }
    }
//    public int getInt(int min, int max) {
//        System.out.printf("Please enter an integer between %d and %d.%n", min, max);
//        int userIntInput;
//            userIntInput = scanner.nextInt();
//        if (userIntInput >= min && userIntInput <= max) {
//            return userIntInput;
//        } else {
//          while(userIntInput < min || userIntInput > max) {
//              System.out.printf("Please enter a valid integer between the range %d to %d.%n", min, max);
//              userIntInput = scanner.nextInt();
//          }
//            return userIntInput;
//        }
//    }
//  // CLASS WALKTHRU
    public int getInt(int min, int max){
        int userInt = this.getInt();
        if (userInt >= min && userInt <= max) {
            return userInt;
        } else {
            System.out.printf("The whole number must be between %d and %d. Please enter again.", min, max);
            return getInt(min, max);
        }
    }

//    //BONUS: PROMPT AS ARGUMENT
public int getInt(String prompt, int min, int max){
    System.out.println(prompt);
    int userInt = this.getInt();
    if (userInt >= min && userInt <= max) {
        return userInt;
    } else {
        System.out.printf("The whole number must be between %d and %d. Please enter again.", min, max);
        return getInt(min, max);
    }
}

//    public double getDouble() {
//        double userDoubleInput = scanner.nextDouble();
//        return userDoubleInput;
//    }

//    // CLASS WALKTHRU
    public double getDouble() {
        try {
            return Double.parseDouble(this.getString());
        } catch (NumberFormatException e) {
            System.out.println("You must enter a number.");
//            // recursion! like a loop. will try to get the input again. and if it is able to be parsed, will return the number.
            return this.getDouble();
        }
    }

//    //BONUS: PROMPT AS ARGUMENT
public double getDouble(String prompt) {
    System.out.println(prompt);
    try {
        return Double.parseDouble(this.getString());
    } catch (NumberFormatException e) {
        System.out.println("You must enter anumber.");
//            // recursion! like a loop. will try to get the input again. and if it is able to be parsed, will return the number.
        return this.getDouble();
    }
}

//    public double getDouble(double minimum, double maximum) {
//        System.out.printf("Please enter a number between %.2f and %.2f.%n", minimum, maximum);
//        double userInput;
//        userInput = scanner.nextDouble();
//        if(userInput >=  minimum && userInput <= maximum) {
//            return userInput;
//        } else {
//            while(userInput < minimum || userInput > maximum) {
//                System.out.printf("Please enter a valid integer between the range %.2f to %.2f.%n", minimum, maximum);
//                userInput = scanner.nextDouble();
//            }
//            return userInput;
//        }
//    }

//    //CLASS WALKTHRU
public double getDouble(double min, double max){
    double userDouble = this.getDouble();
    if (userDouble >= min && userDouble <= max) {
        return userDouble;
    } else {
        System.out.printf("The whole number must be between %d and %d. Please enter again.", min, max);
        return getDouble(min, max);
    }
}

//      // BONUS: PROMPT AS ARGUMENT
public double getDouble(String prompt,double min, double max){
    System.out.println(prompt);
    double userDouble = this.getDouble();
    if (userDouble >= min && userDouble <= max) {
        return userDouble;
    } else {
        System.out.printf("The whole number must be between %d and %d. Please enter again.", min, max);
        return getDouble(min, max);
    }
}
    public long getLong() {
        try {
            return Long.parseLong(this.getString());
        } catch (NumberFormatException e) {
            System.out.println("You must enter a number.");
//            // recursion! like a loop. will try to get the input again. and if it is able to be parsed, will return the number.
            return this.getLong();
        }
    }

    public long getLong(String prompt) {
        System.out.println(prompt);
        try {
            return Long.parseLong(this.getString());
        } catch (NumberFormatException e) {
            System.out.println("You must enter a whole number.");
//            // recursion! like a loop. will try to get the input again. and if it is able to be parsed, will return the number.
            return this.getLong();
        }
    }
}



