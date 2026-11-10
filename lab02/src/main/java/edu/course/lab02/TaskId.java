package edu.course.lab02;

public record TaskId(String value) {
    public TaskId {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException("TaskId cannot be null or empty");
        }
    }
}