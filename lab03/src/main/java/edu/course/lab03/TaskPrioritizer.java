package edu.course.lab03;

public class TaskPrioritizer {
    private final PriorityPolicy priorityPolicy;

    public TaskPrioritizer(PriorityPolicy priorityPolicy) {
        if (priorityPolicy == null) {
            throw new IllegalArgumentException("PriorityPolicy cannot be null");
        }
        this.priorityPolicy = priorityPolicy;
    }

    public ProjectTask chooseMoreImportant(ProjectTask task1, ProjectTask task2) {
        if (task1 == null || task2 == null) {
            throw new IllegalArgumentException("Tasks cannot be null");
        }
        int p1 = priorityPolicy.calculatePriority(task1);
        int p2 = priorityPolicy.calculatePriority(task2);

        return p1 >= p2 ? task1 : task2;
    }
}