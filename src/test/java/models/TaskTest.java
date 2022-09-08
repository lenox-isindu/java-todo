package models;

import org.junit.Test;
import java.time.LocalDateTime;
import static org.junit.Assert.*;

public class TaskTest {
    @Test
    public void NewTaskObjectGetsCorrectlyCreated_true() throws Exception {
        Task task = setupNewTask();
        Assertions.assertEquals(true, task instanceof Task);
    }

    @Test
    public void TaskInstantiatesWithDescription_true() throws Exception {
        Task task = setupNewTask();
        Assertions.assertEquals("Mow the lawn", task.getDescription());
    }

    @Test
    public void isCompletedPropertyIsFalseAfterInstantiation() throws Exception {
        Task task = setupNewTask();
        Assertions.assertEquals(false, task.getCompleted()); //should never start as completed
    }

    @Test
    public void getCreatedAtInstantiatesWithCurrentTimeToday() throws Exception {
        Task task = setupNewTask();
        Assertions.assertEquals(LocalDateTime.now().getDayOfWeek(), task.getCreatedAt().getDayOfWeek());
    }

    //helper methods
    public Task setupNewTask(){
        return new Task("Mow the lawn", 1);
    }
}