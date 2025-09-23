public class ParagraphAnalyzer {

    public static void analyzeAndModify(String paragraph, String wordToReplace, String replacementWord) {
        if (paragraph == null || paragraph.trim().isEmpty()) {
            System.out.println("The paragraph is empty. Cannot analyze.");
            return;
        }


        String[] words = paragraph.trim().split("\\s+");


        System.out.println("Word Count: " + words.length);


        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        System.out.println("Longest Word: " + longestWord);


        String newParagraph = paragraph.replaceAll("(?i)" + wordToReplace, replacementWord);
        System.out.println("\nOriginal Paragraph: " + paragraph);
        System.out.println("Modified Paragraph: " + newParagraph);
    }

    public static void main(String[] args) {
        String text = "Java is a popular programming language. Many developers love Java.";
        analyzeAndModify(text, "Java", "Python");

        System.out.println("\n--- Edge Case: Empty String ---");
        analyzeAndModify("", "a", "b");
    }
}