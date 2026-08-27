package com.todoapi;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskControllerTest {

    @Test
    void createAndRetrieveTask() {
        TaskController controller = new TaskController();
        Task task = new Task(null, "Learn Jenkins", false);
        Task created = controller.create(task);

        assertNotNull(created.getId());
        assertEquals("Learn Jenkins", created.getTitle());
        assertFalse(created.isDone());
    }

    @Test
    void deleteTask() {
        TaskController controller = new TaskController();
        Task created = controller.create(new Task(null, "Temp task", false));
        controller.delete(created.getId());
        assertNull(controller.getOne(created.getId()));
    }
}
