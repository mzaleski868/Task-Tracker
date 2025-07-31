import java.time.LocalDate;
import java.util.*;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    public void addTasks(String description, String dueDate, Task.Priority priority) {
        Task newTask = new Task(description, dueDate, priority);
        tasks.add(newTask);
    }

    public boolean deleteTask(int id) {
        return tasks.removeIf(task -> task.getId() == id);
    }

    public boolean completeTask(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.markComplete();
                return true;
            }
        }
        return false;
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public void sortByDueDate() {
        tasks.sort(Comparator.comparing(Task::getDueDate));
    }

    public void sortByPriority() {
        tasks.sort(Comparator.comparing(Task::getPriority));
    }
}
