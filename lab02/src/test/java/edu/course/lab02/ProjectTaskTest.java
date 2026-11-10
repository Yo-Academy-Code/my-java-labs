package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTaskTest {

    @Test
    void createsTaskSuccessfully() {
        ProjectTask task = new ProjectTask("TASK-1", "Fix bug", TaskStatus.TODO, 5);
        assertEquals("TASK-1", task.getId());
        assertEquals("Fix bug", task.getTitle());
        assertEquals(TaskStatus.TODO, task.getStatus());
        assertEquals(5, task.getEstimatedHours());
        assertFalse(task.isCompleted());
    }

    @Test
    void changesStatusAndChecksCompletion() {
        ProjectTask task = new ProjectTask("TASK-2", "Write tests", TaskStatus.IN_PROGRESS, 3);
        task.changeStatus(TaskStatus.DONE);
        assertEquals(TaskStatus.DONE, task.getStatus());
        assertTrue(task.isCompleted());
    }

    @Test
    void addsEstimatedHours() {
        ProjectTask task = new ProjectTask("TASK-3", "Refactor", TaskStatus.TODO, 2);
        task.addEstimatedHours(4);
        assertEquals(6, task.getEstimatedHours());
    }

    @Test
    void throwsExceptionOnInvalidArguments() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("", "Title", TaskStatus.TODO, 1));
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("1", null, TaskStatus.TODO, 1));
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("1", "Title", TaskStatus.TODO, -5));
        
        ProjectTask task = new ProjectTask("1", "Title", TaskStatus.TODO, 1);
        assertThrows(IllegalArgumentException.class, () -> task.addEstimatedHours(0));
        assertThrows(IllegalArgumentException.class, () -> task.changeStatus(null));
    }
}