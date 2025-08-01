import manager.TaskManager;
import model.Task;
import repository.FileTaskRepository;

import java.util.Scanner;

public class App {
    private static final FileTaskRepository repository = new FileTaskRepository("tasks.csv");
    private static final TaskManager manager = new TaskManager(repository);
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> addTask();
                case 2 -> listTasks();
                case 3 -> completeTask();
                case 4 -> deleteTask();
                case 5 -> sortMenu();
                case 0 -> {
                    manager.saveTasksToFile(); // ✅ Save on exit
                    System.exit(0);
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n==== model.Task Tracker ====");
        System.out.println("1. Add Task");
        System.out.println("2. List Tasks");
        System.out.println("3. Complete Task");
        System.out.println("4. Delete Task");
        System.out.println("5. Sort Tasks");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
    }

    private static void addTask() {
        System.out.print("Description: ");
        String desc = scanner.nextLine();
        System.out.print("Due Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Priority (LOW, MEDIUM, HIGH): ");
        Task.Priority priority = Task.Priority.valueOf(scanner.nextLine().toUpperCase());
        manager.addTasks(desc, date, priority);
        manager.saveTasksToFile(); // ✅ Save after adding
        System.out.println("✅ Task added.");
    }

    private static void listTasks() {
        for (Task task : manager.getAllTasks()) {
            System.out.println(task.toString());
        }
    }

    private static void completeTask() {
        System.out.print("Task ID to mark complete: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (manager.completeTask(id)) {
            manager.saveTasksToFile(); // ✅ Save after completion
            System.out.println("✅ Task marked as complete.");
        } else {
            System.out.println("❌ Task not found.");
        }
    }

    private static void deleteTask() {
        System.out.print("Task ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (manager.deleteTask(id)) {
            manager.saveTasksToFile(); // ✅ Save after delete
            System.out.println("🗑️ Task deleted.");
        } else {
            System.out.println("❌ Task not found.");
        }
    }

    private static void sortMenu() {
        System.out.println("Sort by: 1. Due Date | 2. Priority");
        int choice = Integer.parseInt(scanner.nextLine());
        if (choice == 1) {
            manager.sortByDueDate();
        } else if (choice == 2) {
            manager.sortByPriority();
        } else {
            System.out.println("Error, Invalid input");
            return;
        }
        System.out.println("📋 Sorted.");
    }
}
