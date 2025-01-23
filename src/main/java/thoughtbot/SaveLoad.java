package thoughtbot;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import tasks.Task;
import tasks.TaskDeadline;
import tasks.TaskEvent;
import tasks.TaskToDo;

public class SaveLoad {
    private static final String absoluteFilePath = new File("").getAbsolutePath();
    private static final String relativeFilePath = "/data/thoughtbot.txt";

    private SaveLoad() {
        // to prevent instantiation
    }

    public static boolean save(TaskList currentTaskList) {
        try {
            File saveDir = new File(absoluteFilePath + "/data");
            File saveFile = new File(absoluteFilePath + relativeFilePath);

            if (!saveDir.exists()) {
                saveDir.mkdir();
            }
            if (!saveFile.exists()) {
                saveFile.createNewFile();
            }

            FileWriter saveWrite = new FileWriter(absoluteFilePath + relativeFilePath);

            for (Task t: currentTaskList.getTasks()) {
                String line = parseToSaveFormat(t);
                saveWrite.write(line + System.lineSeparator());
            }

            saveWrite.close();
            return true;
        } catch (IOException e) {
            System.out.printf("File was unable to be created to save: " + e);
            return false;
        }
    }

    private static String parseToSaveFormat(Task t) {
        String retString;
        String doneString = t.getDone() ? "1" : "0";
        String nameString = t.getName();

        if (t.getClass() == TaskToDo.class) {
            retString = "T | " + doneString + " | " + nameString;
        } else if (t.getClass() == TaskDeadline.class) {
            TaskDeadline deadlineT = (TaskDeadline) t;
            String deadlineString = deadlineT.getDeadline();
            retString = "D | " + doneString + " | " + nameString + " | " + deadlineString;
        } else {
            TaskEvent eventT = (TaskEvent) t;
            String fromString = eventT.getFromTime();
            String toString = eventT.getToTime();
            retString = "E | " + doneString + " | " + nameString + " | " + fromString + " | " + toString;
        }

        return retString;
    }

//    public static TaskList load() {
//
//    }
}
