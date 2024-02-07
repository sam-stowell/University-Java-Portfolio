package CIS2206.Unit_11.search;

import CIS2206.Unit_11.tools.Print;
import CIS2206.Unit_11.university.Person;

/**
 * Implements Sequential and Binary Search
 *
 * @author Ilias Tachmazidis
 * @version September 2023
 */
public class PersonSearch {

    /**
     * This method implements Sequential Search based on a given
     * value and array
     *
     * @param value A value to search for
     * @param array An array of elements
     * @return Index of the value within the array, -1 if not found
     */
    public static int sequentialSearch(Person value, Person[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(value) == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * This method implements Binary Search based on a given
     * value and array. Binary Search is called recursively
     * thus, bottom and top might be different in every call.
     *
     * @param bottom Current bottom within the array
     * @param top Current top within the array
     * @param value An value to search for
     * @param array An array of elements
     * @return Index of the value within the array, -1 if not found
     */
    public static int binarySearch(int bottom, int top, Person value, Person[] array) {
        if (bottom > top) {
            return -1;
        } else {
            int pivot = (bottom + top) / 2;
            if (value.compareTo(array[pivot]) == 0) {
                return pivot;
            } else if (value.compareTo(array[pivot]) < 0) {
                return binarySearch(bottom, pivot - 1, value, array);
            } else {
                return binarySearch(pivot + 1, top, value, array);
            }
        }
    }

    /**
     * This method searches for a value within a given array.
     * However, the search algorithm depends of the properties of
     * the array. More specifically, Binary Search is applied on
     * sorted arrays, while Sequential Search is applied on random
     * (not sorted) arrays.
     *
     * @param value A value to search for
     * @param array An array of elements
     * @return Index of the value within the array, -1 if not found
     */
    public static int search(Person value, Person[] array) {
        boolean sorted = true;
        for (int index = 1; index < array.length; index++) {
            if (array[index-1].compareTo(array[index]) > 0) {
                sorted = false;
            }
        }
        if (sorted) {
            return binarySearch(0, array.length-1, value, array);
        } else {
            return sequentialSearch(value, array);
        }
    }

    /**
     * Run search for a given array and value
     *
     * @param args (ignored)
     */
    public static void main(String[] args) {
        Person[] array = new Person[4];
        array[0] = new Person("Jane", "Jane", 25);
        array[1] = new Person("Jack", "John", 40);
        array[2] = new Person("John", "John", 20);
        array[3] = new Person("John", "John", 30);
        Person value = new Person("Jack", "John", 40);

        int index = -1;

        System.out.println("Searching value: " + value +
                "\n\tin array: " +  Print.array(array, array.length));

        index = sequentialSearch(value, array);
        System.out.println("Sequential Search: array[" + index + "] = " +
                (index >= 0? array[index]:"?"));

        index = binarySearch(0, array.length-1, value, array);
        System.out.println("Binary Search: array[" + index + "] = " +
                (index >= 0? array[index]:"?"));

        index = search(value, array);
        System.out.println("Search: array[" + index + "] = " +
                (index >= 0? array[index]:"?"));
    }
}
