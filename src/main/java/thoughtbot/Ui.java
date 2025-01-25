package thoughtbot;

import java.util.Scanner;

import exceptions.ThoughtBotException;
import usercommands.UserCommand;
import usercommands.UserCommandDeadline;
import usercommands.UserCommandDelete;
import usercommands.UserCommandEvent;
import usercommands.UserCommandMarkUnmark;
import usercommands.UserCommandTodo;
import utilities.StringConstants;

/**
 * This is the UI class that handles everything related to interfacing with the user. All command
 * checks and verification is done here.
 */
public class Ui {
    private String userInput;
    private Scanner userInputScanner;
    private String printString;

    /**
     * Constructor for the Ui class
     */
    public Ui() {
        this.userInput = "";
        this.userInputScanner = new Scanner(System.in);
        this.printString = "";
    }

    /**
     * Prints out the standard greeting message on System.out
     */
    public void greet() {
        System.out.println(StringConstants.GREETING);
    }

    /**
     * Prints out the standard goodbye message on System.out
     */
    public void goodbye() {
        System.out.println(StringConstants.GOODBYE);
    }

    public boolean getUserInputAndContinue(TaskList myList) {
        userInput = getUserInputAndContinue(userInputScanner);
        if (!userInput.equalsIgnoreCase("bye")) {
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
                default:
                    break;
                }
            } catch (ThoughtBotException e) {
                printString = e.getMessage();
            } finally {
                printString = indentAndFormat(printString);
                System.out.println(printString);
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the user input from a Scanner object and return it as a String.
     *
     * @param userInputScanner The Scanner object to get inputs from
     * @return User input in a String object
     */
    private String getUserInputAndContinue(Scanner userInputScanner) {
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
