import java.util.Scanner;

import exceptions.ThoughtBotException;
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

            try {
                UserCommand uc = Parser.parseInput(userInput);
                switch (uc.getCommandType()) {
                case LIST:
                    printString = myList.getTaskList();
                    break;
                case TODO:
                    UserCommandTodo todo = (UserCommandTodo) uc;
                    printString = myList.addTodo(todo.getTaskName());
                    printString += myList.getTaskNumbersString();
                    break;
                case DEADLINE:
                    UserCommandDeadline deadline = (UserCommandDeadline) uc;
                    printString = myList.addDeadline(deadline.getTaskName(), deadline.getDeadline());
                    printString += myList.getTaskNumbersString();
                    break;
                case EVENT:
                    UserCommandEvent event = (UserCommandEvent) uc;
                    printString = myList.addEvent(event.getTaskName(), event.getFromTime(), event.getToTime());
                    printString += myList.getTaskNumbersString();
                    break;
                case MARK:
                    UserCommandMarkUnmark mark = (UserCommandMarkUnmark) uc;
                    printString = myList.markEntry(mark.getMarkUnmarkNumber());
                    break;
                case UNMARK:
                    UserCommandMarkUnmark unmark = (UserCommandMarkUnmark) uc;
                    printString = myList.unmarkEntry(unmark.getMarkUnmarkNumber());
                    break;
                }
            } catch (ThoughtBotException e) {
                printString = e.getMessage();
            } finally {
                printString = indentAndFormat(printString);
                System.out.println(printString);
                userInput = getUserInput(userInputScanner);
            }
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
