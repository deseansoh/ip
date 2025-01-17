package userCommands;

import utilities.Command;

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
