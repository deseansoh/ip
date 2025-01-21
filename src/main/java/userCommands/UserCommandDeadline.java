package userCommands;

import utilities.Command;

/**
 * Concrete class that encapsulates information about the DEADLINE command, including
 * the name of the task and the deadline of the task
 */
public class UserCommandDeadline extends UserCommand {
    private String taskName;
    private String deadline;

    public UserCommandDeadline(String taskName, String deadline) {
        super(Command.DEADLINE);
        this.taskName = taskName;
        this.deadline = deadline;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public String getDeadline() {
        return this.deadline;
    }
}
