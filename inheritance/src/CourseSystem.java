// File: CourseSystem.java


class Course {
    String courseName;
    int duration; // in hours

    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    public void displayDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Duration: " + duration + " hours");
    }
}

class OnlineCourse extends Course {
    String platform;
    boolean isRecorded;

    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Platform: " + platform);
        System.out.println("Is Recorded: " + isRecorded);
    }
}

class PaidOnlineCourse extends OnlineCourse {
    double fee;
    double discount;

    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }

    @Override
    public void displayDetails() {
        System.out.println("\n--- Paid Online Course ---");
        super.displayDetails();
        System.out.println("Fee: $" + fee);
        System.out.println("Discount: " + discount + "%");
    }
}

public class CourseSystem {
    public static void main(String[] args) {
        PaidOnlineCourse javaCourse = new PaidOnlineCourse("Advanced Java", 40, "Coursera", true, 500, 10);
        javaCourse.displayDetails();
    }
}
