package edu.course.lab03;

public class ProjectTask {
    private final String id;
    private final String title;
    private final TaskStatus status;
    private final int estimatedHours;

    public ProjectTask(String id, String title, TaskStatus status, int estimatedHours) {
        if (id == null || id.isEmpty()) throw new IllegalArgumentException("Id cannot be empty");
        if (title == null || title.isEmpty()) throw new IllegalArgumentException("Title cannot be empty");
        if (status == null) throw new IllegalArgumentException("Status cannot be null");
        if (estimatedHours < 0) throw new IllegalArgumentException("Hours cannot be negative");

        this.id = id;
        this.title = title;
        this.status = status;
        this.estimatedHours = estimatedHours;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public TaskStatus getStatus() { return status; }
    public int getEstimatedHours() { return estimatedHours; }
}