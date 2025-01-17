import java.util.ArrayList;
import static utilities.StringConstants.SEPARATORNEWLINE;

public class TaskList {
    private ArrayList<Entry> entries;
    String printString = "";

    public TaskList() {
        this.entries = new ArrayList<>(100);
    }

    public String addEntry(String entryName) {
        this.entries.add(new Entry(entryName));
        return "Added task: " + entryName + "\n" + SEPARATORNEWLINE;
    }

    public String markEntry(int number) {
        printString = "";
        if (number > entries.size()) {
            printString += "This task does not exist!\n" + SEPARATORNEWLINE;
            return printString;
        }

        Entry entryToMark = entries.get(number - 1);
        boolean marked = entryToMark.markDone();
        if (marked) {
            printString += "I have marked this task as done.\n" + entryToMark.getName();
        } else {
            printString += "This task has already been marked.";
        }
        printString += "\n" + SEPARATORNEWLINE;
        return printString;
    }

    public String unmarkEntry(int number) {
        printString = "";
        if (number > entries.size()) {
            printString += "This task does not exist!\n" + SEPARATORNEWLINE;
            return printString;
        }

        Entry entryToMark = entries.get(number - 1);
        boolean unmarked = entryToMark.unmarkDone();
        if (unmarked) {
            printString += "I have unmarked this task as done.\n" + entryToMark.getName();
        } else {
            printString += "This task has already been unmarked.";
        }
        printString += "\n" + SEPARATORNEWLINE;
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

        printString = printString + SEPARATORNEWLINE;

        return printString;
    }
}
