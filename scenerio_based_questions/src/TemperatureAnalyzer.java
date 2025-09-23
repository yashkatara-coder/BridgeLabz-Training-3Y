import java.util.Arrays;

public class TemperatureAnalyzer {

    public static void analyzeTemperatures(float[][] weekTemps) {
        if (weekTemps == null || weekTemps.length != 7) {
            System.out.println("Invalid temperature data provided.");
            return;
        }

        float[] dailyAverages = new float[7];
        float maxTemp = Float.MIN_VALUE;
        float minTemp = Float.MAX_VALUE;
        int hottestDayIndex = -1;
        int coldestDayIndex = -1;

        for (int day = 0; day < weekTemps.length; day++) {
            float dailySum = 0;
            float dailyMax = Float.MIN_VALUE;
            float dailyMin = Float.MAX_VALUE;

            if (weekTemps[day].length != 24) {
                System.out.println("Invalid data for day " + (day + 1) + ". Expected 24 hours.");
                continue;
            }

            for (int hour = 0; hour < weekTemps[day].length; hour++) {
                float temp = weekTemps[day][hour];
                dailySum += temp;
                if (temp > dailyMax) dailyMax = temp;
                if (temp < dailyMin) dailyMin = temp;
            }


            dailyAverages[day] = dailySum / 24;

            // Check if this day is the hottest or coldest so far [cite: 33]
            if (dailyMax > maxTemp) {
                maxTemp = dailyMax;
                hottestDayIndex = day;
            }
            if (dailyMin < minTemp) {
                minTemp = dailyMin;
                coldestDayIndex = day;
            }
        }

        System.out.println("Hottest Day: Day " + (hottestDayIndex + 1) + " with a peak of " + maxTemp + "°C");
        System.out.println("Coldest Day: Day " + (coldestDayIndex + 1) + " with a low of " + minTemp + "°C");
        System.out.println("\nDaily Average Temperatures:");
        for (int i = 0; i < dailyAverages.length; i++) {
            System.out.printf("Day %d: %.2f°C\n", (i + 1), dailyAverages[i]);
        }
    }

    public static void main(String[] args) {
        // Example 7x24 temperature data
        float[][] temperatures = new float[7][24];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 24; j++) {
                // Generating some sample data
                temperatures[i][j] = 20 + i * 2 + (float) (Math.random() * 10);
            }
        }
        temperatures[3][14] = 45.5f;
        temperatures[5][3] = 2.1f;

        analyzeTemperatures(temperatures);
    }
}