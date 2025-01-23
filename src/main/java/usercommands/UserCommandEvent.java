package usercommands;

import utilities.Command;

import java.time.LocalDateTime;

/**
 * Concrete class that encapsulates information about the EVENT command, including
 * the name of the task and the from and to time of the task
 */
public class UserCommandEvent extends UserCommand{
    private String taskName;
    private LocalDateTime fromTime;
    private LocalDateTime toTime;

    public UserCommandEvent(String taskName, LocalDateTime fromString, LocalDateTime toString) {
        super(Command.EVENT);
        this.taskName = taskName;
        this.fromTime = fromString;
        this.toTime = toString;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public LocalDateTime getFromTime() {
        return this.fromTime;
    }

    public LocalDateTime getToTime() {
        return this.toTime;
    }
}
