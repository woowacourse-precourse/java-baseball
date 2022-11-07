package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    static final int RESTART_INPUT_NUMBER_LENGTH = 1;
    static final int USER_GUESS_NUMBER_LENGTH = 3;
    static final int RANDOM_NUMBER_LENGTH = 3;
    static final int RANDOM_NUMBER_FIRST_RANGE = 1;
    static final int RANDOM_NUMBER_LAST_RANGE = 9;
    static final int STRIKE = 1;
    static final int NOT_STRIKE = 0;
    static final int BALL = 1;
    static final int NOT_BALL = 0;

    static final String RESTART = "1";
    static final String FINISH = "2";
    static final String BALL_HINT = "볼 ";
    static final String STRIKE_HINT = "스트라이크";
    static final String NOTHING_HINT = "낫싱";
    static final String REGEX_PATTERN = "[+-]?\\d*(\\.\\d+)?";
    static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    static final String REQUEST_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    static final String CORRECT_AND_FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static final String REQUEST_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    static public void startGame() {
        String randomNumber = makeRandomNumber();
        while (inGame(randomNumber)) {}
        finishGame();
    }

    static public String makeRandomNumber() {
        String randomNumber = "";

        while (randomNumber.length() < RANDOM_NUMBER_LENGTH) {
            int randomDigit = Randoms.pickNumberInRange(RANDOM_NUMBER_FIRST_RANGE, RANDOM_NUMBER_LAST_RANGE);
            String randomWord = String.valueOf(randomDigit);
            if (!randomNumber.contains(randomWord)) {
                randomNumber += randomWord;
            }
        }

        return randomNumber;
    }

    static public boolean inGame(String randomNumber) {
        String userGuessNumber = getUserGuessNumber();
        userInputValidator(userGuessNumber);
        printHint(randomNumber, userGuessNumber);
        return isRepeat(randomNumber, userGuessNumber);
    }

    static public String getUserGuessNumber() {
        System.out.print(REQUEST_INPUT_MESSAGE);
        String userGuessNumber = Console.readLine();
        return userGuessNumber;
    }

    static public void userInputValidator(String userGuessNumber) {
        if (userGuessNumber.length() != USER_GUESS_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }

        if (!userGuessNumber.matches(REGEX_PATTERN)) {
            throw new IllegalArgumentException();
        }
    }

    static public void printHint(String randomNumber, String userGuessNumber) {
        int strikeCount = getStrikeCount(randomNumber, userGuessNumber);
        int ballCount = getBallCount(randomNumber, userGuessNumber);
        String hint = makeHint(ballCount, strikeCount);
        System.out.println(hint);
    }

    static public int getStrikeCount(String randomNumber, String userGuessNumber) {
        int strikeCount = 0;

        for (int randomNumberIndex = 0; randomNumberIndex < RANDOM_NUMBER_LENGTH; randomNumberIndex++) {
            for (int userGuessNumberIndex = 0; userGuessNumberIndex < USER_GUESS_NUMBER_LENGTH; userGuessNumberIndex++) {
                char randomNumberDigit = randomNumber.charAt(randomNumberIndex);
                char userGuessNumberDigit = userGuessNumber.charAt(userGuessNumberIndex);
                strikeCount += isStrike(randomNumberIndex, userGuessNumberIndex, randomNumberDigit, userGuessNumberDigit);
            }
        }

        return strikeCount;
    }

    static public int isStrike(int randomNumberIndex, int userGuessNumberIndex, char randomNumberDigit, char userGuessNumberDigit) {
        boolean sameIndex = randomNumberIndex == userGuessNumberIndex;
        boolean sameDigit = randomNumberDigit == userGuessNumberDigit;

        if (sameIndex && sameDigit) {
            return STRIKE;
        }
        return NOT_STRIKE;
    }

    static public int getBallCount(String randomNumber, String userGuessNumber) {
        int ballCount = 0;

        for (int randomNumberIndex = 0; randomNumberIndex < RANDOM_NUMBER_LENGTH; randomNumberIndex++) {
            for (int userGuessNumberIndex = 0; userGuessNumberIndex < USER_GUESS_NUMBER_LENGTH; userGuessNumberIndex++) {
                char randomNumberDigit = randomNumber.charAt(randomNumberIndex);
                char userGuessNumberDigit = userGuessNumber.charAt(userGuessNumberIndex);
                ballCount += isBall(randomNumberIndex, userGuessNumberIndex, randomNumberDigit, userGuessNumberDigit);
            }
        }

        return ballCount;
    }

    static public int isBall(int randomNumberIndex, int userGuessNumberIndex, char randomNumberDigit, char userGuessNumberDigit) {
        boolean sameIndex = randomNumberIndex == userGuessNumberIndex;
        boolean sameDigit = randomNumberDigit == userGuessNumberDigit;

        if (!sameIndex && sameDigit) {
            return BALL;
        }
        return NOT_BALL;
    }

    static public String makeHint(int ballCount, int strikeCount) {
        String hint = "";

        if (ballCount > 0 && strikeCount > 0) {
            hint += ballCount + BALL_HINT + strikeCount + STRIKE_HINT;
        }

        if (ballCount > 0 && strikeCount == 0) {
            hint += ballCount + BALL_HINT;
        }

        if (ballCount == 0 && strikeCount > 0) {
            hint += strikeCount + STRIKE_HINT;
        }

        if (ballCount == 0 && strikeCount == 0) {
            hint += NOTHING_HINT;
        }

        return hint;
    }

    static public boolean isRepeat(String randomNumber, String userGuessNumber) {
        boolean repeat = true;

        if (randomNumber.equals(userGuessNumber)) {
            repeat = false;
        }
        return repeat;
    }

    static public void finishGame() {
        System.out.println(CORRECT_AND_FINISH_MESSAGE);
        String restart = getRestartInput();
        restartInputValidator(restart);
        restartGame(restart);
    }

    static public String getRestartInput() {
        System.out.println(REQUEST_RESTART_MESSAGE);
        String restart = Console.readLine();
        return restart;
    }

    static public void restartInputValidator(String restart) {
        if (restart.length() != RESTART_INPUT_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }

        if (!restart.matches(REGEX_PATTERN)) {
            throw new IllegalArgumentException();
        }

        if (!restart.equals(RESTART) && !restart.equals(FINISH)) {
            throw new IllegalArgumentException();
        }
    }

    static public void restartGame(String restart) {
        if (restart.equals(RESTART)) {
            startGame();
        }
    }

    public static void main(String[] args) {
        System.out.println(GAME_START_MESSAGE);
        startGame();
    }
}