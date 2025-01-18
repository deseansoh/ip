import java.util.ArrayList;
import tasks.*;
import exceptions.OutOfBoundsTaskException;

public class TaskList {
    private ArrayList<Task> tasks;
    String printString = "";

    public TaskList() {
        this.tasks = new ArrayList<>(100);
    }

    public String addTodo(String entryName) {
        Task tTodo = new TaskToDo(entryName);
        this.tasks.add(tTodo);
        return "Added task:\n" + tTodo.getName() + "\n";
    }

    public String addDeadline(String entryName, String deadline) {
        Task tDeadline = new TaskDeadline(entryName, deadline);
        this.tasks.add(tDeadline);
        return "Added task:\n" + tDeadline.getName() + "\n";
    }

    public String addEvent(String entryName, String fromTime, String toTime) {
        Task tEvent = new TaskEvent(entryName, fromTime, toTime);
        this.tasks.add(tEvent);
        return "Added task:\n" + tEvent.getName() + "\n";
    }

    public String markEntry(int number) throws OutOfBoundsTaskException{
        printString = "";
        if (number > tasks.size()) {
            throw new OutOfBoundsTaskException();
        }

        Task taskToMark = tasks.get(number - 1);
        boolean marked = taskToMark.markDone();
        if (marked) {
            printString += "I have marked this task as done.\n" + taskToMark.getName();
        } else {
            printString += "This task has already been marked.";
        }
        printString += "\n";
        return printString;
    }

    public String unmarkEntry(int number) throws OutOfBoundsTaskException{
        printString = "";
        if (number > tasks.size()) {
            throw new OutOfBoundsTaskException();
        }

        Task taskToUnmark = tasks.get(number - 1);
        boolean unmarked = taskToUnmark.unmarkDone();
        if (unmarked) {
            printString += "I have unmarked this task as done.\n" + taskToUnmark.getName();
        } else {
            printString += "This task has already been unmarked.";
        }
        printString += "\n";
        return printString;
    }

    public String getTaskList() {
        printString = "Here are your current tasks:\n";
        int currentNumber = 1;

        for (Task e: tasks) {
            String numberString = String.valueOf(currentNumber);
            currentNumber++;

            printString = printString + numberString + ". " + e.getName() + "\n";
        }

        return printString;
    }

    public String getTaskNumbersString() {
        return "There is/are currently " + String.valueOf(tasks.size()) + " task(s) in the list.\n";
    }
}
