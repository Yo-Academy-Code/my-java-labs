package edu.course.lab03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskPrioritizerTest {

    @Test
    void testEffortPriorityPolicy() {
        ProjectTask task1 = new ProjectTask("1", "Task A", TaskStatus.TODO, 5);
        ProjectTask task2 = new ProjectTask("2", "Task B", TaskStatus.TODO, 15);

        PriorityPolicy policy = new EffortPriorityPolicy();
        TaskPrioritizer prioritizer = new TaskPrioritizer(policy);

        assertEquals(task2, prioritizer.chooseMoreImportant(task1, task2));
    }

    @Test
    void testStatusPriorityPolicy() {
        ProjectTask task1 = new ProjectTask("1", "Task A", TaskStatus.DONE, 10);
        ProjectTask task2 = new ProjectTask("2", "Task B", TaskStatus.TODO, 10);

        PriorityPolicy policy = new StatusPriorityPolicy();
        TaskPrioritizer prioritizer = new TaskPrioritizer(policy);

        assertEquals(task2, prioritizer.chooseMoreImportant(task1, task2));
    }

    @Test
    void testPolicySubstitution() {
        ProjectTask task1 = new ProjectTask("1", "Task A", TaskStatus.DONE, 2);
        ProjectTask task2 = new ProjectTask("2", "Task B", TaskStatus.TODO, 10);

        TaskPrioritizer prioritizer1 = new TaskPrioritizer(new EffortPriorityPolicy());
        assertEquals(task2, prioritizer1.chooseMoreImportant(task1, task2));

        TaskPrioritizer prioritizer2 = new TaskPrioritizer(new StatusPriorityPolicy());
        assertEquals(task2, prioritizer2.chooseMoreImportant(task1, task2));
    }
}