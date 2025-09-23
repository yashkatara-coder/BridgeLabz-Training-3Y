import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentAttendanceTracker {

    /**
     * Computes the number of days each student was present.
     * @param dailyAttendance A variable number of lists, each representing one day's attendance.
     * @return A map where the key is the student's name and the value is their total attendance count.
     */
    public static Map<String, Integer> calculateAttendance(List<String>... dailyAttendance) {
        Map<String, Integer> attendanceMap = new HashMap<>();

        // Loop through each day's attendance list
        for (List<String> day : dailyAttendance) {
            // Loop through each student who attended on that day
            for (String student : day) {
                // Increment the student's attendance count.
                // getOrDefault handles the case where the student is not yet in the map.
                attendanceMap.put(student, attendanceMap.getOrDefault(student, 0) + 1);
            }
        }
        return attendanceMap;
    }

    public static void main(String[] args) {
        List<String> day1 = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> day2 = Arrays.asList("Bob", "David", "Alice");
        List<String> day3 = Arrays.asList("Charlie", "Alice", "Eve");

        Map<String, Integer> totalAttendance = calculateAttendance(day1, day2, day3);

        System.out.println("Student Attendance Report:");
        totalAttendance.forEach((student, count) ->
                System.out.println(student + ": " + count + " days")
        );
    }
}