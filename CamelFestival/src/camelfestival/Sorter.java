package camelfestival;

/**
 * Sorter - the 4 sorting algorithms. All sort DESCENDING by the chosen key.
 * Ties (equal keys) -> Camel ID ascending.
 * OWNER: Part 3
 * Rule: no Arrays.sort / Collections.sort.
 */
public class Sorter {

    // Which field to sort by
    public static final int BY_SCORE = 1;
    public static final int BY_WIN_RATE = 2;
    public static final int BY_HERITAGE = 3;
    public static final int BY_SPEED = 4;

    // true if camel a should come BEFORE camel b in the sorted result:
    // a's key is bigger, OR keys are equal and a's Camel ID is smaller (A to Z).
    // All 4 sorts use this, so the tie-break is written only once.
    public static boolean comesBefore(Camel a, Camel b, int key) {
        return false; // TODO
    }

    public static void selectionSort(Camel[] arr, int key) {
        // TODO
    }

    public static void insertionSort(Camel[] arr, int key) {
        // TODO
    }

    public static void mergeSort(Camel[] arr, int key) {
        // TODO
    }

    public static void quickSort(Camel[] arr, int key) {
        // TODO
    }
}
