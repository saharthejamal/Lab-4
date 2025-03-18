import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Unsorted Array ---------------------------------------------------");
        ArrayList<Integer> integerList = Lab4.getList();
        Lab4.outputList(integerList);

        // Measure time for Bubble Sort
        long bubbleStartTime = System.nanoTime();
        System.out.println("\n\nBubble sort results ----------------------------------------------");
        ArrayList<Integer> bubbleSortedList = Lab4.bubbleSort(new ArrayList<>(integerList)); // Create a copy to avoid modifying the original list
        long bubbleEndTime = System.nanoTime();
        Lab4.outputList(bubbleSortedList);
        System.out.println("\nBubble Sort Time: " + (bubbleEndTime - bubbleStartTime) + " nanoseconds");

        // Measure time for Insertion Sort
        long insertionStartTime = System.nanoTime();
        System.out.println("\n\nInsertion sort results -------------------------------------------");
        ArrayList<Integer> insertionSortedList = Lab4.insertionSort(new ArrayList<>(integerList)); // Create a copy to avoid modifying the original list
        long insertionEndTime = System.nanoTime();
        Lab4.outputList(insertionSortedList);
        System.out.println("\nInsertion Sort Time: " + (insertionEndTime - insertionStartTime) + " nanoseconds");
    }
}

class Lab4 {
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> integerList) {
        int n = integerList.size();
        for (int i = 1; i < n; i++) {
            int key = integerList.get(i);
            int j = i - 1;
            while (j >= 0 && integerList.get(j) > key) {
                integerList.set(j + 1, integerList.get(j)); // Shift element
                j--;
            }
            integerList.set(j + 1, key); // Insert key
        }
        return integerList;
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> integerList) {
        int n = integerList.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (integerList.get(j) > integerList.get(j + 1)) {
                    // Swap
                    int temp = integerList.get(j);
                    integerList.set(j, integerList.get(j + 1));
                    integerList.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break; // If no swaps occur, the list is already sorted
        }
        return integerList;
    }

    public static ArrayList<Integer> getList() {
        ArrayList<Integer> integerList = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("integers.txt"))) {
            while ((line = br.readLine()) != null) {
                integerList.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return integerList;
    }

    public static void outputList(ArrayList<Integer> integerList) {
        for (int num : integerList) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}