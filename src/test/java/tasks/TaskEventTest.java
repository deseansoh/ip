package tasks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskEventTest {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private TaskEvent task;

    @BeforeEach
    public void initialize() {
        task = new TaskEvent("Meet friends",
                LocalDateTime.parse("2000-01-01 12:00", formatter),
                LocalDateTime.parse("2000-01-01 18:00", formatter));
    }

    @Test
    public void getFullName_functionCall_success() {
        String expectedName = "[E][ ] Meet friends (from: 2000-01-01 12:00 | to: 2000-01-01 18:00)";
        assertEquals(expectedName, task.getFullName());
    }

    @Test
    public void getFromTime_functionCall_success() {
        String expectedFromTime = "2000-01-01 12:00";
        assertEquals(expectedFromTime, task.getFromTime());
    }

    @Test
    public void getToTime_functionCall_success() {
        String expectedToTime = "2000-01-01 18:00";
        assertEquals(expectedToTime, task.getToTime());
    }

    @Test
    public void markDone_functionCall_success() {
        String expectedName = "[E][X] Meet friends (from: 2000-01-01 12:00 | to: 2000-01-01 18:00)";
        task.markDone();
        assertEquals(expectedName, task.getFullName());
    }

    @Test
    public void unmarkDone_functionCall_success() {
        String expectedName = "[E][ ] Meet friends (from: 2000-01-01 12:00 | to: 2000-01-01 18:00)";
        task.markDone();
        task.unmarkDone();
        assertEquals(expectedName, task.getFullName());
    }

    @Test
    public void getName_functionCall_success() {
        String expectedName = "Meet friends";
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
