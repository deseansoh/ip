package tasks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskToDoTest {
    private TaskToDo task;

    @BeforeEach
    public void initialize() {
        task = new TaskToDo("Eat food");
    }

    @Test
    public void getFullName_functionCall_success() {
        String expectedName = "[T][ ] Eat food";
        assertEquals(expectedName, task.getFullName());
    }

    @Test
    public void markDone_functionCall_success() {
        String expectedName = "[T][X] Eat food";
        task.markDone();
        assertEquals(expectedName, task.getFullName());
    }

    @Test
    public void unmarkDone_functionCall_success() {
        String expectedName = "[T][ ] Eat food";
        task.markDone();
        task.unmarkDone();
        assertEquals(expectedName, task.getFullName());
    }

    @Test
    public void getName_functionCall_success() {
        String expectedName = "Eat food";
        assertEquals(expectedName, task.getName());
    }

    @Test
    public void getDone_functionCall_success() {
        boolean expectedDone = true;
        task.markDone();
        assertEquals(expectedDone, task.getDone());

        expectedDone = false;
        task.unmarkDone();
        assertEquals(expectedDone, task.getDone());
    }
}
