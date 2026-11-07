package camelfestival;

public class Camel {

    // The 7 fields from the input line
    private String camelId;        // e.g. "CM-4129A" (8 characters)
    private char breedCode;        // 'A', 'M', 'W' or 'H'
    private double winRate;        // 0.0 to 100.0
    private int targetYear;        // 2026 or later
    private int heritageRating;    // 1 to 5
    private String stablesCode;    // e.g. "KSA" (3 letters)
    private double speedVariation; // -100.0 to +100.0

    // Calculated later by Scorer (0 until then)
    private int score;

    // Constructor: creates a camel from the 7 values of a valid line
    public Camel(String camelId, char breedCode, double winRate, int targetYear,
            int heritageRating, String stablesCode, double speedVariation) {
        this.camelId = camelId;
        this.breedCode = breedCode;
        this.winRate = winRate;
        this.targetYear = targetYear;
        this.heritageRating = heritageRating;
        this.stablesCode = stablesCode;
        this.speedVariation = speedVariation;
        this.score = 0;
    }

    // Getters: let other classes READ the fields
    public String getCamelId() {
        return camelId;
    }

    public char getBreedCode() {
        return breedCode;
    }

    public double getWinRate() {
        return winRate;
    }

    public int getTargetYear() {
        return targetYear;
    }

    public int getHeritageRating() {
        return heritageRating;
    }

    public String getStablesCode() {
        return stablesCode;
    }

    public double getSpeedVariation() {
        return speedVariation;
    }

    public int getScore() {
        return score;
    }

    // Setter: only the score changes after the camel is created
    public void setScore(int score) {
        this.score = score;
    }

    // Builds the line for the output files (8 columns), e.g.
    // CM-4129A;A;92.4;2026;5;KSA;12.5;100;
    public String toOutputLine() {
        return camelId + ";" + breedCode + ";" + winRate + ";" + targetYear + ";"
                + heritageRating + ";" + stablesCode + ";" + speedVariation + ";"
                + score + ";";
    }

    // So System.out.println(camel) prints something readable (useful in the demo)
    @Override
    public String toString() {
        return toOutputLine();
    }
}
