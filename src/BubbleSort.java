import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


// superclass
public class BubbleSort {
    // add throws to main method to handle exceptions
    public static void main(String[] args) throws IOException {
        List<String> wordList;
        List<String> sortedWordList;
        List<String> reversedWordList;

        // load the words from file (words with non ascii characters are already removed using notepad++)
        wordList = Files.readAllLines(Paths.get("wordList.txt")); // the original list of words
        sortedWordList = Files.readAllLines(Paths.get("wordList(ascending).txt")); // sorted list of words
        reversedWordList = Files.readAllLines(Paths.get("wordList(descending).txt")); // reversed list of words

        // convert list to array
        String[] wordArray = wordList.toArray(new String[0]);
        String[] sortedWordArray = sortedWordList.toArray(new String[0]);
        String[] reversedWordArray = reversedWordList.toArray(new String[0]);

        Cases bestCase = new Cases(); // initialising first object
        System.out.println("Best case time complexity: ");
        bestCase.sortStrings(sortedWordArray); // method call for best case condition

        Cases averageCase = new Cases(); // initialising second object
        System.out.println("\n\n\nAverage case time complexity: ");
        averageCase.sortStrings(wordArray); // method call for average case condition

        Cases worstCase = new Cases();  // initialising third object
        System.out.println("\n\n\nWorst case time complexity: ");
        worstCase.sortStrings(reversedWordArray); // method call for worst case
    }
}

// subclass
class Cases extends BubbleSort {
    // initialising counter to count how many times primitive operations are performed
    static long counter;

    public static void sortStrings(String[] wordArr) {
        // Sorting strings using bubble sort
        counter = 0;
        int n = 10;
        counter++; // 1 assignment
        String temp;
        for (int i = 0; i < n - 1; ++i) {
            counter++; // assignment of i
            counter+=2; // subtraction n-1, comparison of i < n-1
            for (int j = i + 1; j < n; ++j) {
                counter+=2; // addition of i+1, assignment of j=i+1
                counter++; // comparison of j<n;
                if (wordArr[i].compareTo(wordArr[j]) > 0) {
                    counter+=4; // indexing wordArray[i] and wordArray[j], compareTo method, compare array > 0
                    temp = wordArr[i];
                    wordArr[i] = wordArr[j];
                    wordArr[j] = temp;
                    counter+=7; // 3 assignments, 4 indexing array
                }
                counter+=2; // addition and assignment of j++
                System.out.println("n: " + (i+1) + "\t\tcounter value: " + counter); // print n and counter for all iterations
            }
            counter+=2; // addition and assignment of i++
        }
    }
}



