import java.time.LocalDate;

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
}
