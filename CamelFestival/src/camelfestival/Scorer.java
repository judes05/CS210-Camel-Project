package camelfestival;

public class Scorer {

    private static final int CURRENT_YEAR = 2026;

    // Returns the score for one camel: base 30 + all adjustments,
    // then capped to 0..100. Does NOT store it (Main calls setScore).
    public static int calculateScore(Camel c) {
        /**
         * Scorer - calculates the Seeding Score using the rules table. OWNER:
         */

        // Returns the score for one camel: base 30 + all adjustments,
        // then capped to 0..100. Does NOT store it (Main calls setScore).
        int score = 30;
        score += winRatePoints(c.getWinRate());
        score += urgencyPoints(c.getTargetYear());
        score += heritagePoints(c.getHeritageRating());
        score += speedPoints(c.getSpeedVariation());
        score += breedPoints(c.getBreedCode());

        if (score < 0) {
            score = 0;
        }
        if (score > 100) {
            score = 100;
        }
        return score;
    }

    private static int winRatePoints(double win) {
        if (win > 90) {
            return 30;
        }
        if (win >= 60) {
            return 15;
        }
        if (win >= 30) {
            return 0;
        }
        return -20;
    }

    private static int urgencyPoints(int year) {
        int diff = year - CURRENT_YEAR;
        if (diff == 0) {
            return 40;
        }
        if (diff == 1) {
            return 30;
        }
        if (diff == 2) {
            return 20;
        }
        if (diff <= 5) {
            return 10;
        }
        return 0;
    }

    private static int heritagePoints(int level) {
        if (level == 5) {
            return 25;
        }
        if (level == 4) {
            return 15;
        }
        if (level == 3) {
            return 0;
        }
        if (level == 2) {
            return -10;
        }
        return -20;
    }

    private static int speedPoints(double v) {
        if (v > 10) {
            return 20;
        }
        if (v >= 0) {
            return 10;
        }
        if (v >= -10) {
            return 0;
        }
        return -10;
    }

    private static int breedPoints(char breed) {
        if (breed == 'A') {
            return 15;
        }
        if (breed == 'M') {
            return 10;
        }
        if (breed == 'W') {
            return 5;
        }
        return 0;
    }
}
