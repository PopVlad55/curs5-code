import java.util.Arrays;

public class ConfidentialApp {
    private static String[] sensitiveWords;

    public static void main(String[] args) {
        // 1
        System.out.println(countChar("testare", 't'));
        // 2
        System.out.println(redact("word"));
        // 3
        String[] names = {"George", "Mihai", "Ioana"};
        System.out.println(containsWord(names, "Mihai"));
        // 4
        String[] splitArray = splitString("Ana are mere");

        Arrays.stream(splitArray).forEach(System.out::println);
        for (String word : splitArray) {
            System.out.println(word);
        }
        // 5
        sensitiveWords = new String[]{"mere", "Ana"};
        System.out.println(confidential("Ana are mere multe mere bune"));
    }

    private static String confidential(String input) {
        String[] inputArray = splitString(input);
        for (int index = 0; index < inputArray.length; index++) {
            if (containsWord(sensitiveWords, inputArray[index])) {
                inputArray[index] = redact(inputArray[index]);
            }
        }
        return String.join(" ", inputArray);
    }

    private static String[] splitString(String input) {
        return input.split(" ");
    }

    private static boolean containsWord(String[] names, String toBeFound) {
        for (String name : names) {
            if (name.equals(toBeFound)) {
                return true;
            }
        }
        return false;
    }

    private static String redact(String request) {
        return request.replaceAll(".", "*");
    }

    private static int countChar(String entry, char foundChar) {
        int count = 0;
        for (int index = 0; index < entry.length(); index++) {
            if (entry.charAt(index) == foundChar) {
                count++;
            }
        }
        return count;
    }
}