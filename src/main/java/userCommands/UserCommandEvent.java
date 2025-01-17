package userCommands;

import utilities.Command;

public class UserCommandEvent extends UserCommand{
    private String taskName;
    private String fromTime;
    private String toTime;

    public UserCommandEvent(String taskName, String fromString, String toString) {
        super(Command.EVENT);
        this.taskName = taskName;
        this.fromTime = fromString;
        this.toTime = toString;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public String getFromTime() {
        return this.fromTime;
    }

    public String getToTime() {
        return this.toTime;
    }
}
