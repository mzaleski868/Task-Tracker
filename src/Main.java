import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static final TaskManager manager = new TaskManager();
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
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n==== Task Tracker ====");
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
            System.out.println("✅ Task marked as complete.");
        } else {
            System.out.println("❌ Task not found.");
        }
    }

    private static void deleteTask() {
        System.out.print("Task ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (manager.deleteTask(id)) {
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
