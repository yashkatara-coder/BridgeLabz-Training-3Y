import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ToDoList {
    private final List<String> tasks;

    public ToDoList() {
        this.tasks = new ArrayList<>();
    }


    public void addTask(String task) {
        if (task != null && !task.trim().isEmpty()) {
            tasks.add(task.trim());
            System.out.println("Added task: \"" + task.trim() + "\"");
        } else {
            System.out.println("Cannot add an empty task.");
        }
    }


    public void removeTask(String taskName) {
        if (tasks.remove(taskName)) {
            System.out.println("Removed task: \"" + taskName + "\"");
        } else {
            System.out.println("Error: Task \"" + taskName + "\" not found.");
        }
    }


    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("The to-do list is empty.");
            return;
        }
        Collections.sort(tasks);
        System.out.println("\n--- To-Do List (Sorted) ---");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
        System.out.println("---------------------------");
    }

    public static void main(String[] args) {
        ToDoList myList = new ToDoList();
        myList.addTask("  Buy groceries ");
        myList.addTask("Pay electricity bill");
        myList.addTask("Call the dentist");
        myList.displayTasks();

        myList.removeTask("Pay electricity bill");
        myList.removeTask("Go to the gym"); // Task that doesn't exist
        myList.displayTasks();
    }
}
