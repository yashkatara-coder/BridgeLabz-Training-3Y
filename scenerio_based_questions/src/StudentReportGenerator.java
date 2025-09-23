import java.util.ArrayList;
import java.util.List;

class InvalidMarkException extends Exception {
    public InvalidMarkException(String message) {
        super(message);
    }
}

class StudentRecord {
    String name;
    int[] marks;
    String[] subjects;

    public StudentRecord(String name, String[] subjects, int[] marks) throws InvalidMarkException {
        this.name = name;
        this.subjects = subjects;
        // Validate marks [cite: 87]
        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarkException("Invalid mark: " + mark + ". Marks must be between 0 and 100.");
            }
        }
        this.marks = marks;
    }

    public double calculateAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (double) total / marks.length;
    }

    public String assignGrade() {
        double average = calculateAverage();
        if (average >= 90) return "A+";
        if (average >= 80) return "A";
        if (average >= 70) return "B";
        if (average >= 60) return "C";
        return "F";
    }

    public void displayResult() { // [cite: 88]
        System.out.println("---------------------------------");
        System.out.println("        STUDENT REPORT CARD      ");
        System.out.println("---------------------------------");
        System.out.println("Student Name: " + this.name);
        System.out.println("---------------------------------");
        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%-15s : %d\n", subjects[i], marks[i]);
        }
        System.out.println("---------------------------------");
        System.out.printf("Average Score: %.2f\n", calculateAverage());
        System.out.println("Final Grade: " + assignGrade());
        System.out.println("---------------------------------\n");
    }
}

public class StudentReportGenerator {
    public static void main(String[] args) {
        List<StudentRecord> studentList = new ArrayList<>(); // [cite: 85]
        String[] subjects = {"Math", "Science", "History"}; // [cite: 84]

        try {
            studentList.add(new StudentRecord("John Doe", subjects, new int[]{95, 88, 76}));
            studentList.add(new StudentRecord("Jane Smith", subjects, new int[]{100, 92, 98}));
            // This one will throw an exception
            studentList.add(new StudentRecord("Invalid Student", subjects, new int[]{45, 105, 60}));
        } catch (InvalidMarkException e) {
            System.err.println("Error creating student record: " + e.getMessage());
        }

        // Display reports for valid students
        for(StudentRecord student : studentList) {
            student.displayResult(); // [cite: 86]
        }
    }
}