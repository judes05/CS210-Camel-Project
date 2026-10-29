package camelfestival;

/**
 * InputReader - reads the input file, validates every line,
 * and builds the linked list from the VALID lines only.
 * OWNER: Part 2
 */
public class InputReader {

    // inputFile: e.g. "Input.txt"
    // errorFile: e.g. "Errors.txt". Each invalid line is written as:
    //            Line 57: <the line> -> <reason>
    //            If errorFile is null, still skip invalid lines but write no file
    //            (the benchmark uses this, because benchmark runs write no files).
    // Returns the list of valid camels (scores not calculated yet).
    public static CamelLinkedList readFile(String inputFile, String errorFile) {
        return new CamelLinkedList(); // TODO
    }
}
