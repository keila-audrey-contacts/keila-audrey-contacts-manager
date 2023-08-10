package util;

public class InputTest {
    public static void main(String[] args) {

//       // TEST GETSTRING METHOD
//        System.out.println("Please enter your name.");
//        Input userInput = new Input();
//        String usersName = userInput.getString();
//        System.out.printf("The users name is %s", usersName);

////        //TEST BOOLEAN METHOD
//        System.out.println("Do you want a cookie?[yes/no]");
//        Input userInput = new Input();
//        boolean userConfirm = userInput.yesNo();
//        System.out.printf("You input %s", userConfirm);

//        //TEST GETINT(min, max) METHOD
//        Input userInput = new Input();
//        System.out.println("Please enter an integer between 1 and 10.");
//        int userInputInt = userInput.getInt(1,10);
//        System.out.printf("The number you chose is %d", userInputInt);

//        //TEST GETINT() METHOD
//        System.out.println("Please put in a number.");
//        Input userInput = new Input();
//        int userInputInt = userInput.getInt();
//        System.out.printf("This is the number you entered %d.%n", userInputInt);

//        //TEST GETDOUBLE(min, max) METHOD
//        Input userInput = new Input();
//        double userInputNum = userInput.getDouble(1,100.2);
//        System.out.println(userInputNum);

//        //TEST GETDOUBLE METHOD
        Input userInput = new Input();
//        System.out.println("Please enter a number.");
//        double userInputNum = userInput.getDouble();
//        System.out.printf("You chose the number %.2f.%n", userInputNum);

        //TEST GETSTRING WITH PROMPT
        System.out.println(userInput.getString("Enter your name."));
    }
}
