import java.util.Scanner;
import utilities.Constants;

public class ThoughtBot {
    public static void main(String[] args) {
        String userInput;
        Scanner userInputScanner = new Scanner(System.in);
        TaskList myList = new TaskList();

        System.out.println(Constants.GREETING);

        userInput = getUserInput(userInputScanner);

        while (!userInput.equalsIgnoreCase("bye")) {
            switch (userInput.toLowerCase()) {
            case "list":
                myList.displayTaskList();
                break;
            default:
                myList.addEntry(userInput);
            }

            userInput = getUserInput(userInputScanner);
        }

        System.out.println(Constants.GOODBYE);
    }

    public static String getUserInput(Scanner userInputScanner) {
        String userInput = userInputScanner.nextLine();
        System.out.println(Constants.SEPARATOR);
        return userInput;
    }
}
