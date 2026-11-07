package camelfestival;

public class Main {

    public static void main(String[] args) {

        // read the camels from the input file into the linked list
        long start = System.nanoTime();
        CamelLinkedList list = InputReader.readFile("Input.txt", "Errors.txt");
        long readTime = System.nanoTime() - start;

        // calculate the score for every camel
        start = System.nanoTime();
        Camel[] camels = list.toArray();
        for (int i = 0; i < camels.length; i++) {
            int score = Scorer.calculateScore(camels[i]);
            camels[i].setScore(score);
        }
        long processTime = System.nanoTime() - start;

        // write the camels with their scores to the output file
        start = System.nanoTime();
        OutputWriter.writeFile(list.toArray(), "Output.txt");
        long writeTime = System.nanoTime() - start;

        // each sort uses a new copy of the array so they don't affect each other

        // selection sort by score
        Camel[] ssArray = list.toArray();
        start = System.nanoTime();
        Sorter.selectionSort(ssArray, Sorter.BY_SCORE);
        long ssTime = System.nanoTime() - start;
        OutputWriter.writeFile(ssArray, "Sorted_Output_SS.txt");

        // insertion sort by win rate
        Camel[] isArray = list.toArray();
        start = System.nanoTime();
        Sorter.insertionSort(isArray, Sorter.BY_WIN_RATE);
        long isTime = System.nanoTime() - start;
        OutputWriter.writeFile(isArray, "Sorted_Output_IS.txt");

        // merge sort by heritage
        Camel[] msArray = list.toArray();
        start = System.nanoTime();
        Sorter.mergeSort(msArray, Sorter.BY_HERITAGE);
        long msTime = System.nanoTime() - start;
        OutputWriter.writeFile(msArray, "Sorted_Output_MS.txt");

        // quick sort by speed
        Camel[] qsArray = list.toArray();
        start = System.nanoTime();
        Sorter.quickSort(qsArray, Sorter.BY_SPEED);
        long qsTime = System.nanoTime() - start;
        OutputWriter.writeFile(qsArray, "Sorted_Output_QS.txt");

        // print how long each step took (nanoTime gives nanoseconds, so divide to get ms)
        System.out.println("Execution times:");
        System.out.printf("Read: %.3f ms%n", readTime / 1000000.0);
        System.out.printf("Process: %.3f ms%n", processTime / 1000000.0);
        System.out.printf("Write: %.3f ms%n", writeTime / 1000000.0);
        System.out.printf("Selection sort: %.3f ms%n", ssTime / 1000000.0);
        System.out.printf("Insertion sort: %.3f ms%n", isTime / 1000000.0);
        System.out.printf("Merge sort: %.3f ms%n", msTime / 1000000.0);
        System.out.printf("Quick sort: %.3f ms%n", qsTime / 1000000.0);

        // testing search on the linked list
        // CM-0000X is not in the file, to check the not found case
        System.out.println();
        System.out.println("Linked list test:");

        String[] ids = {"CM-4920M", "CM-6997W", "CM-0000X"};
        for (int i = 0; i < ids.length; i++) {
            Camel c = list.search(ids[i]);
            if (c != null) {
                System.out.println("Search " + ids[i] + ": found -> " + c);
            } else {
                System.out.println("Search " + ids[i] + ": not found");
            }
        }

        // testing delete, size should go down by one
        System.out.println("Size before delete: " + list.size());
        boolean deleted = list.delete("CM-6997W");
        System.out.println("Delete CM-6997W: " + deleted);
        System.out.println("Size after delete: " + list.size());
    }
}