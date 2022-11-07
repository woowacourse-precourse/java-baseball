package baseball.view;

class InputValidator {
    private static final int VALID_BASEBALL_LENGTH = 3;
    private static final char START_RANGE = '1';
    private static final char END_RANGE = '9';
    private static final String VALID_GAME_STATUS_PLAY = "1";
    private static final String VALID_GAME_STATUS_STOP = "2";

    private InputValidator() {
    }

    public static void validateBaseballNumber(String baseballNumber) {
        if (baseballNumber.length() != VALID_BASEBALL_LENGTH
                || getDistinctNumberCount(baseballNumber) != VALID_BASEBALL_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private static long getDistinctNumberCount(String baseballNumber) {
        return baseballNumber.chars()
                .filter(InputValidator::isValidNumberRange)
                .distinct()
                .count();
    }

    private static boolean isValidNumberRange(int number) {
        return START_RANGE <= number && number <= END_RANGE;
    }

    public static void validateGameStatus(String gameStatus) {
        if (!gameStatus.equals(VALID_GAME_STATUS_PLAY) && !gameStatus.equals(VALID_GAME_STATUS_STOP)) {
            throw new IllegalArgumentException();
        }
    }
}
