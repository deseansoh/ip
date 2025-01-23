package usercommands;

import utilities.Command;

import java.time.LocalDateTime;

/**
 * Concrete class that encapsulates information about the DEADLINE command, including
 * the name of the task and the deadline of the task
 */
public class UserCommandDeadline extends UserCommand {
    private String taskName;
    private LocalDateTime deadline;

    public UserCommandDeadline(String taskName, LocalDateTime deadline) {
        super(Command.DEADLINE);
        this.taskName = taskName;
        this.deadline = deadline;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public LocalDateTime getDeadline() {
        return this.deadline;
    }
}
