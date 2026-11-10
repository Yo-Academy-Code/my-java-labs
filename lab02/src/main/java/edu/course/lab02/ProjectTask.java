package edu.course.lab02;

public class ProjectTask {
    private final String id;
    private final String title;
    private TaskStatus status;
    private int estimatedHours;

    public ProjectTask(String id, String title, TaskStatus status, int estimatedHours) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Id cannot be null or empty");
        }
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (status == null) {
            throw new IllegalArgumentException("Status cannot be null");
        }
        if (estimatedHours < 0) {
            throw new IllegalArgumentException("Estimated hours cannot be negative");
        }

        this.id = id;
        this.title = title;
        this.status = status;
        this.estimatedHours = estimatedHours;
    }

    public void changeStatus(TaskStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("New status cannot be null");
        }
        this.status = newStatus;
    }

    public boolean isCompleted() {
        return this.status == TaskStatus.DONE;
    }

    public void addEstimatedHours(int hours) {
        if (hours <= 0) {
            throw new IllegalArgumentException("Hours to add must be positive");
        }
        this.estimatedHours += hours;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }
}