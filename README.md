# 📝 Task Tracker

A simple Java-based task tracker that allows users to add, edit, delete, and sort tasks by due date or priority. Tasks can also be saved to and loaded from a local file.

## 🚀 Features

- Add new tasks with description, due date, and priority
- Edit or delete existing tasks
- Mark tasks as complete
- Sort tasks by due date or priority
- Save tasks to a file and load them later
- File-based repository system for persistence (via `FileTaskRepository`)

## 📦 Technologies Used

- Java (Standard Edition)
- Java Collections Framework
- File I/O (`BufferedReader`, `BufferedWriter`, `FileReader`, `FileWriter`)

## 📸 Example Output

[1] Finish Java project | Due: 2025-08-01 | Priority: HIGH | ❌ Incomplete  
[2] Submit resume | Due: 2025-08-05 | Priority: MEDIUM | ✅ Done

## 🛠️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/Task-Tracker.git
   cd Task-Tracker

2. Compile and run (using terminal):

   ```bash
   javac -d out src/model/*.java src/manager/*.java src/repository/*.java src/App.java
   java -cp out App

3. Or open in an IDE like IntelliJ and run App.java.

📌 Future Enhancements

- GUI with JavaFX or Swing
- Export to JSON
- Recurring tasks or reminders
- Web version with Spring Boot

🧑‍💻 Author
Matt Zaleski
GitHub: @mzaleski868