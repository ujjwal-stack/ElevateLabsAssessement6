# TodoApp - Java To-Do Application

A modern, well-structured Java Swing application for managing tasks with priority levels and completion tracking. This project demonstrates **clean Object-Oriented Programming (OOP) principles**, reusable components, and a professional UI design.

---

## 📁 Project Structure

### TodoApp/
  - ├── src/
    - ├── todo/
      - ├── TodoApp.java (Main application class)
      - ├── TaskItem.java (Task item component)
      - ├── AppColors.java (Color constants)
      - ├── GradientPanel.java (Custom gradient panel)
      - └── UIHelper.java (UI utility methods)

    ---

## 🎯 Class Overview

### 1. `TodoApp.java` - Main Application
- Entry point with `main()` method.
- Manages the main UI and overall layout.
- Handles task addition, deletion, and task counting.
- Coordinates interactions between components.

### 2. `TaskItem.java` - Individual Task Component
- Represents a single task item in the ToDo list.
- Stores task data: text, priority, completion status.
- Manages its own UI panel with checkbox and delete button.
- Handles user actions like marking complete or deleting a task.

### 3. `AppColors.java` - Color Constants
- Centralizes all color definitions.
- Makes updating the color scheme simple and consistent.
- Follows DRY principle for maintainability.

### 4. `GradientPanel.java` - Custom Panel
- Custom `JPanel` with a gradient background.
- Overrides `paintComponent()` for smooth, professional rendering.
- Demonstrates creation of reusable custom components.

### 5. `UIHelper.java` - UI Utility Class
- Contains reusable methods for creating buttons and other UI components.
- Reduces code duplication.
- Ensures a consistent UI design across the application.

---

## 🔧 Setup Instructions

### Step 1: Create a New Java Project
1. Open **Eclipse IDE**.
2. Go to **File → New → Java Project**.
3. Enter **Project Name:** `TodoApp`.
4. Click **Finish**.

### Step 2: Add Java Classes
For each file, do the following:
1. Right-click the `src` folder → **New → Class**.
2. Enter the class name (without `.java` extension).
3. For `TodoApp.java`, check **public static void main(String[] args)**.
4. Write the respective code from the project artifacts.

Classes to create:
- `TodoApp.java` ✅
- `TaskItem.java` ✅
- `AppColors.java` ✅
- `GradientPanel.java` ✅
- `UIHelper.java` ✅

### Step 3: Run the Application
1. Right-click **TodoApp.java** → **Run As → Java Application**.
2. The ToDo App window will launch.

---

## 💡 Key Benefits of This Structure
- **Separation of Concerns**: Each class has a clearly defined responsibility.
- **Maintainability**: Easy to modify or extend individual components.
- **Reusability**: Helper classes and UI components can be used in other projects.
- **Scalability**: Add new features or modules easily without breaking existing code.
- **Professional Quality**: Follows industry-standard OOP best practices.
- **Interview Ready**: Demonstrates strong understanding of OOP, Java Swing, and software architecture.

---

## 🖥️ Features
- Add, delete, and mark tasks as complete.
- Set task priorities: High, Medium, Low (with color coding).
- Responsive UI with custom gradient backgrounds.
- Task count tracking and dynamic updates.
- Clean, modern design with professional UI elements.

---

## 🔗 License
This project is open-source and free to use under the MIT License.

---
