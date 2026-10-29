package camelfestival;

/**
 * Main - runs the whole program in order and times each step.
 * OWNER: Part 1
 */
public class Main {

    public static void main(String[] args) {
        // 1. READ:    list = InputReader.readFile("Input.txt", "Errors.txt")   (time it)
        // 2. PROCESS: for each camel in list.toArray(): setScore(Scorer.calculateScore(camel))   (time it)
        // 3. WRITE:   OutputWriter.writeFile(list.toArray(), "Output.txt")   (time it)
        // 4. SORT:    4 times: arr = list.toArray(); time the sort; write the Sorted_Output file
        //             Selection BY_SCORE    -> Sorted_Output_SS.txt
        //             Insertion BY_WIN_RATE -> Sorted_Output_IS.txt
        //             Merge     BY_HERITAGE -> Sorted_Output_MS.txt
        //             Quick     BY_SPEED    -> Sorted_Output_QS.txt
        // 5. DEMO:    search 3 IDs (1 fake), print size, delete 1, print size
        // 6. Print all 7 timings
    }
}
