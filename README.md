# 📝 Task Tracker

A simple Java-based task tracker that allows users to add, edit, delete, and sort tasks by due date or priority. Tasks can also be saved to and loaded from a local file.

## 🚀 Features

- Add new tasks with description, due date, and priority
- Edit or delete existing tasks
- Mark tasks as complete
- Sort tasks by due date or priority
- Save tasks to a file and load them later

## 📦 Technologies Used

- Java (Standard Edition)
- Java Collections Framework
- Java Time API (`java.time.LocalDate`)
- File I/O (`BufferedReader`, `BufferedWriter`, `FileReader`, `FileWriter`)
- (Optional) IntelliJ IDEA or VS Code

## 📸 Example Output

[1] Finish Java project | Due: 2025-08-01 | Priority: HIGH | ❌ Incomplete
[2] Submit resume | Due: 2025-08-05 | Priority: MEDIUM | ✅ Done

bash
Copy
Edit

## 🛠️ How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/Task-Tracker.git
   cd Task-Tracker
Compile and run (using terminal):

bash
Copy
Edit
javac -d out src/*.java
java -cp out Main
Or open in an IDE like IntelliJ and run Main.java.

📁 Project Structure
arduino
Copy
Edit
Task-Tracker/
├── src/
│   ├── Main.java
│   ├── Task.java
│   └── TaskManager.java
├── data/
│   └── tasks.txt  ← (auto-created when saving tasks)
├── README.md
└── .gitignore
📌 Future Enhancements
GUI with JavaFX or Swing

Export to CSV or JSON

Recurring tasks or reminders

Web version with Spring Boot

🧑‍💻 Author
Matt Zaleski
GitHub: @mzaleski868
