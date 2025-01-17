import java.util.ArrayList;
import entries.*;

public class TaskList {
    private ArrayList<Entry> entries;
    String printString = "";

    public TaskList() {
        this.entries = new ArrayList<>(100);
    }

    public String addEntry(String entryName) {
        this.entries.add(new EntryToDo(entryName));
        return "Added task: " + entryName + "\n";
    }

    public String markEntry(int number) {
        printString = "";
        if (number > entries.size()) {
            printString += "This task does not exist!\n";
            return printString;
        }

        Entry entryToMark = entries.get(number - 1);
        boolean marked = entryToMark.markDone();
        if (marked) {
            printString += "I have marked this task as done.\n" + entryToMark.getName();
        } else {
            printString += "This task has already been marked.";
        }
        printString += "\n";
        return printString;
    }

    public String unmarkEntry(int number) {
        printString = "";
        if (number > entries.size()) {
            printString += "This task does not exist!\n";
            return printString;
        }

        Entry entryToUnmark = entries.get(number - 1);
        boolean unmarked = entryToUnmark.unmarkDone();
        if (unmarked) {
            printString += "I have unmarked this task as done.\n" + entryToUnmark.getName();
        } else {
            printString += "This task has already been unmarked.";
        }
        printString += "\n";
        return printString;
    }

    public String getTaskList() {
        printString = "Here are your current tasks:\n";
        int currentNumber = 1;

        for (Entry e: entries) {
            String numberString = String.valueOf(currentNumber);
            currentNumber++;

            printString = printString + numberString + ". " + e.getName() + "\n";
        }

        return printString;
    }
}
