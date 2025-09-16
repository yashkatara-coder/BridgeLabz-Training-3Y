// File: SchoolSystem.java


class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayRole() {
        System.out.println("Role: Generic Person");
    }
}

class Teacher extends Person {
    String subject;

    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    @Override
    public void displayRole() {
        System.out.println("\n-- Teacher Details --");
        System.out.println("Name: " + name);
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}

class Student extends Person {
    int grade;

    public Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    @Override
    public void displayRole() {
        System.out.println("\n-- Student Details --");
        System.out.println("Name: " + name);
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        Person teacher = new Teacher("Mr. Smith", 45, "Math");
        Person student = new Student("Jane Doe", 15, 10);

        teacher.displayRole();
        student.displayRole();
    }
}