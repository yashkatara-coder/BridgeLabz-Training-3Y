

// Blueprint for a Student.
class Student {
    // static variables are shared by all Student objects.
    private static String universityName;
    private static int totalStudents = 0;

    // final variable cannot be changed.
    private final int rollNumber;

    // Instance variables
    private String name;
    private char grade;

    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++;
    }

    public static void setUniversityName(String name) {
        universityName = name;
    }

    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    public void displayStudentDetails() {
        if (this instanceof Student) {
            System.out.println("University Name: " + universityName);
            System.out.println("Roll Number: " + this.rollNumber);
            System.out.println("Name: " + this.name);
            System.out.println("Grade: " + this.grade);
        }
    }

    public void updateGrade(char newGrade) {
        this.grade = newGrade;
        System.out.println("Grade for " + this.name + " updated to: " + newGrade);
    }
}

// Main class to run the program.
public class UniversityManagement {
    public static void main(String[] args) {
        Student.setUniversityName("Global University");

        Student student1 = new Student("Hemashree", 101, 'A');
        Student student2 = new Student("Sharmila", 102, 'B');

        Student.displayTotalStudents();

        System.out.println("\n--- Student 1 Details ---");
        student1.displayStudentDetails();
        System.out.println("\n--- Student 2 Details ---");
        student2.displayStudentDetails();

        System.out.println();
        student2.updateGrade('A');
        System.out.println("\n--- Student 2 Updated Details ---");
        student2.displayStudentDetails();
    }
}
