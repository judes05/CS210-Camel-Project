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

    double valueA;
    double valueB;

    switch (key) {

        case BY_SCORE:
            valueA = a.getScore();
            valueB = b.getScore();
            break;

        case BY_WIN_RATE:
            valueA = a.getWinRate();
            valueB = b.getWinRate();
            break;

        case BY_HERITAGE:
            valueA = a.getHeritageRating();
            valueB = b.getHeritageRating();
            break;

        case BY_SPEED:
            valueA = a.getSpeedVariation();
            valueB = b.getSpeedVariation();
            break;

        default:
            throw new IllegalArgumentException("Invalid sorting key");
    }

    if (valueA != valueB) {
        return valueA > valueB;
    }

    return a.getCamelId().compareTo(b.getCamelId()) < 0;
}


  
public static void selectionSort(Camel[] arr, int key) {

    for (int i = 0; i < arr.length - 1; i++) {

        int best = i;

        for (int j = i + 1; j < arr.length; j++) {

            if (comesBefore(arr[j], arr[best], key)) {
                best = j;
            }
        }

        Camel temp = arr[i];
        arr[i] = arr[best];
        arr[best] = temp;
    }
}


   
public static void insertionSort(Camel[] arr, int key) {

    for (int i = 1; i < arr.length; i++) {

        Camel current = arr[i];
        int j = i - 1;

        while (j >= 0 && comesBefore(current, arr[j], key)) {

            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = current;
    }
}

public static void mergeSort(Camel[] arr, int key) {

    if (arr.length <= 1) {
        return;
    }

    int mid = arr.length / 2;

    Camel[] left = new Camel[mid];
    Camel[] right = new Camel[arr.length - mid];

    for (int i = 0; i < mid; i++) {
        left[i] = arr[i];
    }

    for (int i = mid; i < arr.length; i++) {
        right[i - mid] = arr[i];
    }

    mergeSort(left, key);
    mergeSort(right, key);

    merge(arr, left, right, key);
}

private static void merge(
        Camel[] arr, Camel[] left, Camel[] right, int key) {

    int i = 0;
    int j = 0;
    int k = 0;

    while (i < left.length && j < right.length) {

        if (comesBefore(left[i], right[j], key)) {
            arr[k] = left[i];
            i++;
        } else {
            arr[k] = right[j];
            j++;
        }

        k++;
    }

    while (i < left.length) {
        arr[k] = left[i];
        i++;
        k++;
    }

    while (j < right.length) {
        arr[k] = right[j];
        j++;
        k++;
    }
}


    
public static void quickSort(Camel[] arr, int key) {

    if (arr.length <= 1) {
        return;
    }

    quickSort(arr, 0, arr.length - 1, key);
}

private static void quickSort(
        Camel[] arr, int low, int high, int key) {

    if (low < high) {

        int pivotIndex = partition(arr, low, high, key);

        quickSort(arr, low, pivotIndex - 1, key);
        quickSort(arr, pivotIndex + 1, high, key);
    }
}

private static int partition(
        Camel[] arr, int low, int high, int key) {

    Camel pivot = arr[high];

    int i = low - 1;

    for (int j = low; j < high; j++) {

        if (comesBefore(arr[j], pivot, key)) {

            i++;

            Camel temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    Camel temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1;
}

}
