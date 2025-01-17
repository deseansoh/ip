import java.util.Scanner;
import utilities.StringConstants;
import userCommands.*;

public class ThoughtBot {
    public static void main(String[] args) {
        String userInput;
        Scanner userInputScanner = new Scanner(System.in);
        TaskList myList = new TaskList();
        String printString = "";

        greet();

        userInput = getUserInput(userInputScanner);
        while (!userInput.equalsIgnoreCase("bye")) {
            UserCommand uc = Parser.parseInput(userInput);

            switch (uc.getCommandType()) {
            case LIST:
                printString = myList.getTaskList();
                break;
            case TODO:
                UserCommandTodo todo = (UserCommandTodo) uc;
                printString = myList.addTodo(todo.getTaskName());
                break;
            case DEADLINE:
                UserCommandDeadline deadline = (UserCommandDeadline) uc;
                printString = myList.addDeadline(deadline.getTaskName(), deadline.getDeadline());
                break;
            case MARK:
                UserCommandMarkUnmark markCom = (UserCommandMarkUnmark) uc;
                printString = myList.markEntry(markCom.getMarkUnmarkNumber());
                break;
            case UNMARK:
                UserCommandMarkUnmark unmarkCom = (UserCommandMarkUnmark) uc;
                printString = myList.unmarkEntry(unmarkCom.getMarkUnmarkNumber());
                break;
            case NIL:
                printString = "Sorry, I do not understand the command!\n"
                        + "Do ensure the format is right\n";
            }

            printString = indentAndFormat(printString);
            System.out.println(printString);

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
        return userInput;
    }

    public static String indentAndFormat(String response) {
        String[] lines = response.split("\n");
        response = StringConstants.INDENT + StringConstants.SEPARATORNEWLINE;
        for (String l: lines) {
            response += StringConstants.INDENT + l + "\n";
        }
        response += StringConstants.INDENT + StringConstants.SEPARATORNEWLINE;
        return response;
    }
}
