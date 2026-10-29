# CS210 Project – Camel Pedigree & Race Seeding System

## Who owns which file
Only the owner edits her file. `Camel.java` is shared: change it only after telling the group.

| File | Owner | What it does |
|---|---|---|
| `Camel.java` | Judy (shared) | Holds one camel record (7 fields + score) |
| `CamelLinkedList.java` | Judy | Our own linked list: addLast, size, search, delete, toArray |
| `Main.java` | Judy | Runs everything in order, timings, search/delete demo |
| `InputReader.java` | Part 2 | Reads + validates Input.txt, writes Errors.txt, builds the list |
| `Scorer.java` | Part 2 | Calculates the Seeding Score |
| `OutputWriter.java` | Part 2 | Writes camels to a file (Output.txt + 4 sorted files) |
| `Sorter.java` | Part 3 | Selection, Insertion, Merge, Quick sort + tie-break |
| `Benchmark.java` | Part 3 | Times the 4 sorts on the 1k–40k files (avg of 5 runs) |

## The agreed method names (don't rename them)
```java
// Camel
new Camel(String camelId, char breedCode, double winRate, int targetYear,
          int heritageRating, String stablesCode, double speedVariation)
getCamelId()  getBreedCode()  getWinRate()  getTargetYear()
getHeritageRating()  getStablesCode()  getSpeedVariation()  getScore()
setScore(int score)
toOutputLine()   // "CM-4129A;A;92.4;2026;5;KSA;12.5;100;"

// CamelLinkedList
void addLast(Camel c)
int size()
Camel search(String camelId)     // null if not found
boolean delete(String camelId)   // false if not found
Camel[] toArray()                // new array, same camels, list order

// InputReader
static CamelLinkedList readFile(String inputFile, String errorFile)  // errorFile null = write no file

// Scorer
static int calculateScore(Camel c)

// OutputWriter
static void writeFile(Camel[] camels, String fileName)

// Sorter (all descending; ties -> Camel ID A to Z)
BY_SCORE, BY_WIN_RATE, BY_HERITAGE, BY_SPEED
static boolean comesBefore(Camel a, Camel b, int key)
static void selectionSort(Camel[] arr, int key)
static void insertionSort(Camel[] arr, int key)
static void mergeSort(Camel[] arr, int key)
static void quickSort(Camel[] arr, int key)
```

## Rules
- No ArrayList, LinkedList, Arrays.sort or any built-in collection/sort.
- Put the input .txt files in the main project folder (next to `src`, not inside it), so `"Input.txt"` is found.
- Test with `Test_Input.txt` first and compare with the expected Test files.
- Reused code from a website or the textbook repo: cite it in a comment at the top.
- Work on your own branch, then open a Pull Request into `main`.
