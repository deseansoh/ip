package thoughtbot;

import java.util.Scanner;

import utilities.StringConstants;

import usercommands.UserCommand;
import usercommands.UserCommandTodo;
import usercommands.UserCommandDeadline;
import usercommands.UserCommandEvent;
import usercommands.UserCommandDelete;
import usercommands.UserCommandMarkUnmark;

import exceptions.ThoughtBotException;

/**
 * The ThoughBot class is the main class for the chatbot that helps you
 * keep track of tasks.
 */
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
                case DELETE:
                    UserCommandDelete delete = (UserCommandDelete) uc;
                    printString = myList.deleteTask(delete.getDeleteNumber());
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

        SaveLoad.save(myList);
        goodbye();
    }

    /**
     * Prints out the standard greeting message on System.out
     */
    private static void greet() {
        System.out.println(StringConstants.GREETING);
    }

    /**
     * Prints out the standard goodbye message on System
     */
    private static void goodbye() {
        System.out.println(StringConstants.GOODBYE);
    }

    /**
     * Gets the user input from a Scanner object and return it as a String.
     *
     * @param userInputScanner The Scanner object to get inputs from
     * @return User input in a String object
     */
    private static String getUserInput(Scanner userInputScanner) {
        String userInput = userInputScanner.nextLine();
        return userInput;
    }

    /**
     * Takes in a response to be printed and formats it according to the chatbot
     * with two spacer lines, and 4 spaces of indentation
     *
     * @param response Response to be printed out to the user
     * @return Modified response with proper formatting
     */
    private static String indentAndFormat(String response) {
        String[] lines = response.split("\n");
        response = StringConstants.INDENT + StringConstants.SEPARATORNEWLINE;
        for (String l: lines) {
            response += StringConstants.INDENT + l + "\n";
        }
        response += StringConstants.INDENT + StringConstants.SEPARATORNEWLINE;
        return response;
    }
}
