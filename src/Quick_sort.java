import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

    public class Quick_sort {

        static long counter; // Initialize the variable counter
        
           // This method will return the finished quick sort array 

           public <P extends Comparable<P>> P[] quick_sort(P[] sortArray, int n) {
               counter=0;
               sorting(sortArray, 0, n); 
               counter++; // 1 substraction of sortArray.length - 1 and 1 call of sorting function
               counter++; // 1 return of sortArray
               return sortArray;
           }

           // This function swaps the element in the sortArray
           // start is the index of the first element and end is the index of the second element

           static <P> boolean swaping(P[] sortArray, int start, int end){
               P temp = sortArray[start]; 
               sortArray[start] = sortArray[end];
               sortArray[end] = temp;
               counter+=7; //3 assignments , 4 indexing array

               counter++; //1 return of true
               return true;
           }
       
       
           // This function compares the FirstElement with the SecondElement
           // and return true if FirstElement is lesser than the SecondElement

           static <P extends Comparable<P>> boolean lesser(P FirstElement, P SecondElement) {
               counter+=3; // 1 return, 2 comparisons 
               return FirstElement.compareTo(SecondElement) < 0;
           }
       
           // Sorting the sortArray

           private static <P extends Comparable<P>> void sorting(P[] sortArray, int LEFT, int RIGHT) {
               if (LEFT < RIGHT) {
                   counter++; //comparison of left < right
                   int PIVOT = partitioning(sortArray, LEFT, RIGHT);
                   counter+=2; // 1 assignment of PIVOT and 1 calling of the function partition
                   sorting(sortArray, LEFT, PIVOT - 1);
                   counter+=2; // 1 PIVOT subtraction and 1 calling of the function doSort
                   sorting(sortArray, PIVOT , RIGHT);
                   counter++; // 1 calling of the function doSort
               }
           }
       
           // This method partitions the sortArray to find the pivot in the array
       
           private static <P extends Comparable<P>> int partitioning(P[] sortArray, int LEFT, int RIGHT) {
               int middle = (LEFT + RIGHT) / 2; 
               counter+=3; // 1 assignment of middle, 1 addition and 1 division 

               P PIVOT = sortArray[middle];
               counter+=2; // 1 assignment of pivot and 1 indexing array
       
               while(LEFT <= RIGHT) {
                   counter++; // 1 comparison of left <= right 

                   while(lesser(sortArray[LEFT], PIVOT)){
                       counter+=2; 
                       // 1 function call of lesser and 1 indexing of array
                       ++LEFT;
                       counter++; // addition of left
                   }
                   while(lesser(PIVOT, sortArray[RIGHT])) {
                       counter+=2; 
                       // 1 function call of lesser and 1 indexing of array
                       --RIGHT;
                       counter++; // 1 addition of right
                   }
                   if(LEFT <= RIGHT) {
                       counter++; // 1 comparison of left <= right

                       swaping(sortArray, LEFT, RIGHT); // 1 calling of swaping function to swap the elements' positions
                       counter++; // 1 calling of swaping function

                       ++LEFT;
                       counter++; // 1 addition of left

                       --RIGHT;
                       counter++; // 1 addition of right
                   }
               }
               counter++; // 1 return of left
               return LEFT;
           }
        
        


    // This is the main method that have throws to handle exception
    public static void main(String[] args) throws IOException {
        List<String> wordList_1, wordList_2, wordList_3;

        // get the data from the file and assign to wordList
        wordList_1 = Files.readAllLines(Paths.get("wordList(Ascending).txt"));
        wordList_2 = Files.readAllLines(Paths.get("wordList(Descending).txt"));
        wordList_3 = Files.readAllLines(Paths.get("wordList.txt"));

         // assigning the data from the list into a string array
        String[] wordArray_1 = wordList_1.toArray(new String[0]); 
        String[] wordArray_2 = wordList_2.toArray(new String[0]);
        String[] wordArray_3 = wordList_3.toArray(new String[0]);

        // Initializing the object quickSort
        Quick_sort quickSort_1 = new Quick_sort(); 
        Quick_sort quickSort_2 = new Quick_sort();
        Quick_sort quickSort_3 = new Quick_sort();

        // assigning the length of array into n, m, k
        int n = wordArray_1.length - 1;
        int m = wordArray_2.length - 1;
        int k = wordArray_3.length - 1;

        quickSort_1.quick_sort(wordArray_1, n); // calling function quick_sort from the class Quick_sort

        // Output of the primitive operation counter
        System.out.println("The best case: " + counter);

        quickSort_2.quick_sort(wordArray_2, m); // calling function quick_sort from the class Quick_sort

        /// Output of the primitive operation counter
        System.out.println("The average case: " + counter);

        quickSort_3.quick_sort(wordArray_3, k); // calling function quick_sort from the class Quick_sort

        // Output of the primitive operation counter
        System.out.println("The worst case: " + counter);

    }
}

