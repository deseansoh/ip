package userCommands;

import utilities.Command;

public class UserCommandTodo extends UserCommand{
    private String taskName;

    public UserCommandTodo(String taskName) {
        super(Command.TODO);
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }
}
