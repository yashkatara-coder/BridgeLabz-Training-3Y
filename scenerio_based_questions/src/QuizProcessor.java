import java.util.ArrayList;
import java.util.List;

class InvalidQuizSubmissionException extends Exception {
    public InvalidQuizSubmissionException(String message) {
        super(message);
    }
}

public class QuizProcessor {
    private final String[] correctAnswers;
    private final List<Integer> allUserScores = new ArrayList<>(); // [cite: 77]

    public QuizProcessor(String[] correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public int calculateScore(String[] userAnswers) throws InvalidQuizSubmissionException {
        // Validate input length [cite: 78]
        if (userAnswers.length != correctAnswers.length) {
            throw new InvalidQuizSubmissionException("Submission has " + userAnswers.length + " answers but expected " + correctAnswers.length);
        }

        int score = 0;
        for (int i = 0; i < correctAnswers.length; i++) {
            if (correctAnswers[i].equalsIgnoreCase(userAnswers[i])) {
                score++;
            }
        }
        return score;
    }

    public String getGrade(int score, int totalQuestions) {
        double percentage = ((double) score / totalQuestions) * 100;
        if (percentage >= 90) return "A";
        if (percentage >= 80) return "B";
        if (percentage >= 70) return "C";
        if (percentage >= 60) return "D";
        return "F";
    }

    public void processSubmission(String[] userAnswers) {
        try {
            int score = calculateScore(userAnswers); // [cite: 76]
            allUserScores.add(score);
            String grade = getGrade(score, correctAnswers.length);
            System.out.println("Submission processed. Score: " + score + "/" + correctAnswers.length + ". Grade: " + grade);
        } catch (InvalidQuizSubmissionException e) {
            System.err.println("Error processing submission: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String[] correct = {"A", "C", "B", "D", "A"}; // [cite: 75]
        QuizProcessor platform = new QuizProcessor(correct);

        String[] user1Answers = {"A", "C", "B", "D", "A"}; // Perfect score
        String[] user2Answers = {"A", "B", "B", "D", "B"}; // Partial score
        String[] user3Answers = {"A", "C"}; // Invalid submission

        platform.processSubmission(user1Answers);
        platform.processSubmission(user2Answers);
        platform.processSubmission(user3Answers);
    }
}