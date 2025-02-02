package thoughtbot;

import exceptions.ThoughtBotException;
import usercommands.*;
import utilities.StringConstants;

/**
 * The ThoughtBot class is the main class for the chatbot that helps you
 * keep track of tasks.
 */
public class ThoughtBot {

    private String printString = "";
    private TaskList myList = SaveLoad.load();

    public String getResponse(String userInput) {
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
                case FIND:
                    UserCommandFind find = (UserCommandFind) uc;
                    printString = myList.findTasks(find.getFindString());
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
                System.out.println(printString);
            }
            return printString;
        } else {
            SaveLoad.save(myList);
            return "bye given";
        }
    }
}
