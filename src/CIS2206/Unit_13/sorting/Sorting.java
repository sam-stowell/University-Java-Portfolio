package CIS2206.Unit_13.sorting;

import CIS2206.Unit_13.tools.Print;
import CIS2206.Unit_13.university.Person;

import java.util.Arrays;

/**
 * Implements Bubble Sort, Selection Sort, Insertion Sort,
 * Merge Sort and Quick Sort
 *
 * @author Ilias Tachmazidis
 * @version September 2023
 */
public class Sorting {

    /**
     * An enumeration of implemented sorting algorithms
     */
    public enum SortingAlgorithm { BubbleSort, SelectionSort,
        InsertionSort, MergeSort, QuickSort };

    /**
     * An auxiliary function that swaps elements within a given array
     *
     * @param array An array to swap elements
     * @param from The index of the array from where the element will be moved
     * @param to The index of the array to where the element will be moved
     * @param <T> A generic type
     */
    public static <T> void swap(T[] array, int from, int to){
        T tmp = array[from];
        array[from] = array[to];
        array[to] = tmp;
    }

    /**
     * This method implements the Bubble Sort algorithm
     * in order to sort a given array.
     *
     * @param array An array to be sorted
     * @param <T> A generic type
     */
    public static <T extends Comparable<? super T>>
            void bubbleSort(T[] array) {
        for (int lastUnsorted = array.length - 1;  // the whole list is unsorted
             lastUnsorted > 0; // stop when the whole list is sorted
             lastUnsorted--) { // one new element sorted each time round

            for (int nextToCompare = 0; // start comparing the first two elements
                 nextToCompare < lastUnsorted; // stop at the end of the unsorted portion
                 nextToCompare++) { // move to the next element

                if (array[nextToCompare].compareTo(array[nextToCompare + 1]) > 0) {
                    // the elements are in the wrong order so swap them around
                    swap(array,nextToCompare,nextToCompare+1);
                }
            }
        }
    }

    /**
     * This method implements the Selection Sort algorithm
     * in order to sort a given array.
     *
     * @param array An array to be sorted
     * @param <T> A generic type
     */
    public static <T extends Comparable<? super T>> void
            selectionSort(T[] array) {
        for (int lastUnsorted = array.length - 1; // the whole list is unsorted
             lastUnsorted > 0; // stop when the whole list is sorted
             lastUnsorted--) { // one new element sorted each time round

            int index = lastUnsorted; // set last element as largest unsorted element

            for (int nextToCompare = 0; // start comparing the first element
                 nextToCompare < lastUnsorted; // stop at the end of the unsorted portion
                 nextToCompare++) { // move to the next element

                if (array[nextToCompare].compareTo(array[index]) > 0) {
                    // A larger unsorted element was found, update index
                    index = nextToCompare;
                }
            }
            // Swap elements, move largest element to the end of unsorted list
            swap(array, index, lastUnsorted);
        }
    }

    /**
     * This method implements the Insertion Sort algorithm
     * in order to sort a given array.
     *
     * @param array An array to be sorted
     * @param <T> A generic type
     */
    public static <T extends Comparable<? super T>> void
            insertionSort(T[] array) {
        for (int sorted = 0; // only the first element is sorted
             sorted < array.length - 1; // stop when the whole list is sorted
             sorted++) { // one new element sorted each time round

            T newElement = array[sorted + 1]; // first unsorted element

            int compareTo = sorted; // start by comparing last sorted
            while (compareTo >= 0 && // move until the start of sorted list
                    newElement.compareTo(array[compareTo]) < 0) {

                // move gap to the left
                array[compareTo + 1] = array[compareTo];
                compareTo--;
            }
            // put unsorted element into gap
            array[compareTo + 1] = newElement;
        }
    }

    /**
     * This method implements the Merge Sort algorithm
     * in order to sort a given array.
     *
     * @param array An array to be sorted
     * @param <T> A generic type
     */
    public static <T extends Comparable<? super T>> void
            mergeSort(T[] array) {
        // Apply merge sort as long as there are at least two
        // elements in the array
        if (array.length < 2) {
            return;
        }

        // Create a copy of lower and upper arrays
        T[] lowerArray = Arrays.copyOfRange(array, 0, array.length / 2);
        T[] upperArray = Arrays.copyOfRange(array, array.length / 2, array.length);

        // Call merge sort recursively on lower array
        mergeSort(lowerArray);
        // Call merge sort recursively on upper array
        mergeSort(upperArray);
        // merge lower and upper arrays into the initial array
        merge(array, lowerArray, upperArray);
    }

    /**
     * This method merges lowerArray and upperArray into a
     * single array. The resulting array is sorted
     *
     * @param array The final merged array (to be sorted)
     * @param lowerArray A sorted sub array
     * @param upperArray A sorted sub array
     * @param <T> A generic type
     */
    public static <T extends Comparable<? super T>> void
            merge(T[] array, T[] lowerArray, T[] upperArray) {
        int arrayIndex = 0, lowerIndex = 0, upperIndex = 0;

        // gradually merge lowerArray and upperArray into array
        while (lowerIndex < lowerArray.length && upperIndex < upperArray.length) {
            // lowerArray has the minimum value
            if (lowerIndex < lowerArray.length && lowerArray[lowerIndex].compareTo(upperArray[upperIndex]) < 0) {
                array[arrayIndex] = lowerArray[lowerIndex++];
            } else {
                array[arrayIndex] = upperArray[upperIndex++];
            }
            arrayIndex++;
        }

        // lowerArray has some values left (upperArray is empty)
        while (lowerIndex < lowerArray.length) {
            array[arrayIndex] = lowerArray[lowerIndex];
            lowerIndex++;
            arrayIndex++;
        }

        // upperArray has some values left (lowerArray is empty)
        while (upperIndex < upperArray.length) {
            array[arrayIndex] = upperArray[upperIndex];
            upperIndex++;
            arrayIndex++;
        }
    }

    /**
     * This method implements Quick Sort algorithm
     * in order to sort a given array.
     *
     * @param array An array to be sorted
     * @param low The lowest limit in current sub array
     * @param high The highest limit in current sub array
     * @param <T> A generic type
     */
    public static <T extends Comparable<? super T>> void
            quickSort(T[] array, int low, int high) {
        // Apply quick sort as long as there are at least two elements
        // in the current subset of the array
        if (low < high) {
            // Partition the subset of the array into three parts
            // (small, pivot, large). Pivot element is placed
            // in the correct position
            int pivot_index = partition(array, low, high);

            // Call quick sort recursively on lower part
            quickSort(array, low, pivot_index  - 1);
            // Call quick sort recursively on upper part
            quickSort(array, pivot_index  + 1, high);
        }
    }

    /**
     * This method chooses a pivot within the array and
     * partitions the subset of the array into three parts
     * (small, pivot, large). Small means elements are less
     * that pivot, while large means elements are more than
     * pivot.
     *
     * @param array An array to be sorted
     * @param low The lowest limit in current sub array
     * @param high The highest limit in current sub array
     * @return The position of the pivot
     * @param <T> A generic type
     */
    public static <T extends Comparable<? super T>> int
            partition(T[] array, int low, int high) {

        T pivot = array[high]; // choose pivot
        int store = low; // start from low

        for (int i = low; i <= high - 1; i++) {
            // Move elements that are smaller than the pivot to the
            // left of the correct position of the pivot
            if (array[i].compareTo(pivot) < 0) {
                swap(array, store, i); // swap small elements
                store++; // move index to the right
            }
        }

        // Place pivot in correct position
        swap(array, store, high);

        return store;
    }

    /**
     * This method sorts a given array based on the chosen
     * sorting algorithm
     *
     * @param array The array to be sorted
     * @param sortingAlgorithm An implemented sorting algorithm
     * @param <T> A generic type
     */
    public static <T extends Comparable<? super T>> void
            sort(T[] array, SortingAlgorithm sortingAlgorithm) {

        System.out.println("Array before sorting: " + Print.array(array, array.length));

        switch (sortingAlgorithm) {
            case BubbleSort: bubbleSort(array); break;
            case SelectionSort: selectionSort(array); break;
            case InsertionSort: insertionSort(array); break;
            case MergeSort: mergeSort(array); break;
            case QuickSort: quickSort(array,0,array.length-1); break;
            default: System.out.println("Please choose a sorting algorithm");
        }

        System.out.println("Array after sorting:  " + Print.array(array, array.length));

    }

    /**
     * Sort arrays based on different sorting algorithms
     *
     * @param args (ignored)
     */
    public static void main(String[] args) {
        Integer[] array = {4, 3, 5, 1, 9, 24, 7, 40, 18, 15};

        //Double[] array = {1.7, 1.5, 1.4, 1.2, 1.6, 1.3};

        //String[] array = {"sort", "an", "array", "of", "strings"};

        /*
        Person[] array = new Person[4];
        array[0] = new Person("John", "John", 30);
        array[1] = new Person("John", "John", 20);
        array[2] = new Person("Jack", "John", 40);
        array[3] = new Person("Jane", "Jane", 25);
        */

        SortingAlgorithm sortingAlgorithm = SortingAlgorithm.BubbleSort;

        sort(array, sortingAlgorithm);
    }
}
