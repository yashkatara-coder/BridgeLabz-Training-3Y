public class SentenceFormatter {


    public static String formatSentence(String paragraph) {
        if (paragraph == null || paragraph.trim().isEmpty()) {
            return "";
        }

        // Trim leading/trailing spaces and replace multiple spaces with a single one. [cite: 22]
        String trimmed = paragraph.trim().replaceAll("\\s+", " ");

        // Ensure one space after punctuation marks (. ! ?). [cite: 20]
        trimmed = trimmed.replaceAll("\\s*([.!?])\\s*", "$1 ");

        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        for (char c : trimmed.toCharArray()) {
            if (capitalizeNext && Character.isLetter(c)) {
                result.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                result.append(c);
            }

            if (c == '.' || c == '?' || c == '!') {
                capitalizeNext = true;
            }
        }
        return result.toString().trim();
    }

    public static void main(String[] args) {
        String badParagraph = "  hello world. this is a test!  how are you? i am fine.  ";
        System.out.println("Original: " + badParagraph);
        String corrected = formatSentence(badParagraph);
        System.out.println("Corrected: " + corrected);

        String anotherBadPara = "what time is it? it is    almost five.   let's go.  ";
        System.out.println("\nOriginal: " + anotherBadPara);
        String corrected2 = formatSentence(anotherBadPara);
        System.out.println("Corrected: " + corrected2);
    }
}