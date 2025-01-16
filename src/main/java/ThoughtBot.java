import java.util.Scanner;
import utilities.StringConstants;
import userCommands.*;

public class ThoughtBot {
    public static void main(String[] args) {
        String userInput;
        Scanner userInputScanner = new Scanner(System.in);
        TaskList myList = new TaskList();

        greet();

        userInput = getUserInput(userInputScanner);
        while (!userInput.equalsIgnoreCase("bye")) {
            UserCommand uc = Parser.parseInput(userInput);

            switch (uc.getCommandType()) {
            case LIST:
                myList.displayTaskList();
                break;
            case MARK:
                UserCommandMarkUnmark ucmu= (UserCommandMarkUnmark) uc;
                myList.markEntry(ucmu.getMarkUnmarkNumber());
                break;
            case UNMARK:
                break;
            case NIL:
                myList.addEntry(userInput);
            }

            userInput = getUserInput(userInputScanner);
        }

        goodbye();
    }

    public static void greet() {
        System.out.println(StringConstants.GREETING);
    }

    public static void goodbye() {
        System.out.println(StringConstants.GOODBYE);
    }

    public static String getUserInput(Scanner userInputScanner) {
        String userInput = userInputScanner.nextLine();
        System.out.println(StringConstants.SEPARATOR);
        return userInput;
    }
}
