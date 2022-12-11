import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


// superclass
public class InsertionSort {
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

        // size of array that needs to be sorted
        Case bestCase = new Case(); // creating object
        Case averageCase = new Case();
        Case worstCase = new Case();

        // method calls via object
        long bestCount = bestCase.insertSort(sortedWordArray, sortedWordArray.length);
        System.out.println(bestCount);
        long avgCount = averageCase.insertSort(wordArray, wordArray.length);
        System.out.println(avgCount);
        long worstCount= worstCase.insertSort(reversedWordArray, reversedWordArray.length);
        System.out.println(worstCount);
    }
}

// subclass
class Case extends InsertionSort {
    // initialising counter to count how many times primitive operations are used
    static long counter = 0;

    public static long insertSort(String[] wordArr, int n) {
        // Sorting strings using insertion sort
        counter = 0;
        String temp;
        for (int i = 1; i < n; i++) {
            counter += 2; // assignment of i, comparison of i < n
            temp = wordArr[i];
            int j = i - 1;
            counter+=2; // 2 assignment
            while (j >= 0 && wordArr[j].compareTo(wordArr[i]) > 0) {
                counter += 2; // comparison of j>=0, comparison of array and temp
                wordArr[j + 1] = wordArr[j];
                j = j - 1;
                counter += 2; // 2 assignment
            }
            wordArr[j + 1] = temp;
            counter++; // 1 assignment of array
            counter += 2; // addition and assignment of i++
        }
        return counter;
    }

}



