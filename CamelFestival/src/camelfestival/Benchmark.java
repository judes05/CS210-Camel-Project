
package camelfestival;

/**
 * Benchmark - times the 4 sorts (all BY_SCORE) on Input_1k .. Input_40k.
 * Each time = average of 5 runs. Each run sorts a FRESH unsorted copy.
 * Writes NO output files. Run this file separately from Main.
 * OWNER: Part 3
 */
public class Benchmark {

    private static final int RUNS = 5;

    public static void main(String[] args) {

        String[] inputFiles = {
            "Input_1k.txt",
            "Input_5k.txt",
            "Input_10k.txt",
            "Input_20k.txt",
            "Input_40k.txt"
        };

        String[] sortNames = {
            "Selection Sort",
            "Insertion Sort",
            "Merge Sort",
            "Quick Sort"
        };

        for (String inputFile : inputFiles) {

            CamelLinkedList list = InputReader.readFile(inputFile, null);
            Camel[] original = list.toArray();

            // Calculate each camel's score before benchmarking.
            for (Camel camel : original) {
                camel.setScore(Scorer.calculateScore(camel));
            }

            System.out.println("\nFile: " + inputFile);
            System.out.println("------------------------------");

            for (int sort = 0; sort < 4; sort++) {

                long totalTime = 0;

                for (int run = 0; run < RUNS; run++) {

                    // Create a fresh copy for every run.
                    Camel[] copy = original.clone();

                    long start = System.nanoTime();

                    switch (sort) {
                        case 0:
                            Sorter.selectionSort(copy, Sorter.BY_SCORE);
                            break;
                        case 1:
                            Sorter.insertionSort(copy, Sorter.BY_SCORE);
                            break;
                        case 2:
                            Sorter.mergeSort(copy, Sorter.BY_SCORE);
                            break;
                        case 3:
                            Sorter.quickSort(copy, Sorter.BY_SCORE);
                            break;
                    }

                    long end = System.nanoTime();
                    totalTime += (end - start);
                }

                double averageMillis =
                        (totalTime / (double) RUNS) / 1_000_000.0;

                System.out.printf("%s: %.3f ms%n",
                        sortNames[sort], averageMillis);
            }
        }
    }
}
