package usercommands;

import utilities.Command;

/**
 * Concrete class that encapsulates information about the TODO command, being
 * the name of the task
 */
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
