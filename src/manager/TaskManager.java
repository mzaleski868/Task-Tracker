package manager;

import model.Task;
import repository.TaskRepository;

import java.util.*;
import java.io.*;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();
    private final TaskRepository repository;

    public TaskManager(TaskRepository repository) {
        this.repository = repository;
        this.tasks = repository.loadTasks(); // Load tasks on startup
    }

    public void loadTasksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("tasks.csv"))) {
            tasks.clear(); // optional: start fresh
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(Task.fromCSV(line));
            }
        } catch (IOException e) {
            System.out.println("No saved task file found or failed to load.");
        }
    }

    public void saveTasksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tasks.csv"))) {
            for (Task task : tasks) {
                writer.write(task.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Failed to save tasks: " + e.getMessage());
        }
    }


    public void saveTasks() {
        repository.saveTasks(tasks); // Save on exit
    }

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
