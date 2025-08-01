package model;

public class Task {
    private static int idCounter = 1;
    private int id;
    private String description;
    private String dueDate;
    private Priority priority;
    private boolean isCompleted;

    public enum Priority {
        LOW, MEDIUM, HIGH
    }

    public Task(String description, String dueDate, Priority priority) {
        this.id = idCounter++;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.isCompleted = false;
    }

    // Constructor for loading from file (use existing ID and completion state)
    public Task(int id, String description, String dueDate, Priority priority, boolean isCompleted) {
        this.id = id;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.isCompleted = isCompleted;

        // Make sure idCounter is always ahead of loaded IDs
        if (id >= idCounter) {
            idCounter = id + 1;
        }
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getDueDate() {
        return dueDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markComplete() {
        this.isCompleted = true;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s | Due: %s | Priority: %s | %s",
                id, description, dueDate, priority, isCompleted ? "✅ Done" : "❌ Incomplete");
    }

    public String toCSV() {
        return String.format("%d,%s,%s,%s,%b",
                id, description, dueDate.toString(), priority, isCompleted);
    }

    public static Task fromCSV(String line) {
        String[] parts = line.split(",");
        int id = Integer.parseInt(parts[0]);
        String description = parts[1];
        String dueDate = parts[2];
        Priority priority = Priority.valueOf(parts[3]);
        boolean isCompleted = Boolean.parseBoolean(parts[4]);

        return new Task(id, description, dueDate, priority, isCompleted);
    }
}
