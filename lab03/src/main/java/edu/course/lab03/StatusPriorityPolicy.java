package edu.course.lab03;

public class StatusPriorityPolicy implements PriorityPolicy {
    @Override
    public int calculatePriority(ProjectTask task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null");
        }
        return switch (task.getStatus()) {
            case DONE -> 1;
            case IN_PROGRESS -> 2;
            case TODO -> 3;
        };
    }
}