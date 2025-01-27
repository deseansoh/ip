package usercommands;

import utilities.Command;

/**
 * Concrete class that encapsulates information about the find command, being
 * the word to be matched
 */
public class UserCommandFind extends UserCommand {
    public String taskWord;

    /**
     * Constructor for the UserCommandFind class
     * @param taskWord String to be matched
     */
    public UserCommandFind(String taskWord) {
        super(Command.FIND);
        this.taskWord = taskWord;
    }

    public String getTaskWord() {
        return taskWord;
    }
}
