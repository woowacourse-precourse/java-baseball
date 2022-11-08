package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.ArrayList;

public class Application {
    private static final String GAME_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String REPLAY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_LENGTH_ERROR_MESSAGE = "입력한 값이 3자리가 아닙니다.";
    private static final String INPUT_REPLAY_ERROR_MESSAGE = "재시작이나 종료를 위해서는 1이나 2를 입력해야 합니다.";
    private static final String INPUT_NOT_NUMERIC_ERROR_MESSAGE = "숫자가 아닌 문자가 입력되었습니다.";
    private static final String INPUT_DUPLICATED_ERROR_MESSAGE = "중복된 숫자가 입력되었습니다.";
    private static final String RESULT_NOTHING_MESSAGE = "낫싱";
    private static final String BALL_STRING = "볼";
    private static final String STRIKE_STRING = "스트라이크";
    private static final String THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    private static final int INPUT_BASEBALL_LENGTH = 3;
    private static final int INPUT_REPLAY_LENGTH = 1;
    private static final int MAX_STRIKE = 3;

    private static final char REPLAY = '1';
    private static final char END = '2';

    public static void main(String[] args) {
        boolean playGame = true;

        while (playGame) {
            playGame = false;
            gameStart();

            if(willReplay()) {
                playGame = true;
            }
        }

    }

    static void gameStart() throws IllegalArgumentException {
        System.out.println(START_MESSAGE);

        int[] computerNumber = initializeComputerNumber();
        boolean playBaseball = true;

        while (playBaseball) {
            String stringUserInput = getUserInput(InputType.BASEBALL_NUMBER);
            isValidInput(stringUserInput, InputType.BASEBALL_NUMBER);

            int[] userInput = stringToIntegerArray(stringUserInput);
            int ball = countBalls(userInput, computerNumber);
            int strike = countStrikes(userInput, computerNumber);

            printResult(ball, strike);

            if (isThreeStrike(strike)) {
                System.out.println(THREE_STRIKE_MESSAGE);
                playBaseball = false;
            }
        }
    }

    static int[] initializeComputerNumber() {
        List<Integer> computerNumberList = new ArrayList<>();

        while (computerNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computerNumberList.contains(randomNumber)) {
                computerNumberList.add(randomNumber);
            }
        }

        int[] computerNumberArray = computerNumberList.stream().mapToInt(i -> i).toArray();

        return computerNumberArray;
    }

    static String getUserInput(InputType inputType) {
        if (inputType == InputType.BASEBALL_NUMBER) {
            System.out.print(GAME_INPUT_MESSAGE);

        } else if (inputType == InputType.WILL_REPLAY) {

            System.out.println(REPLAY_MESSAGE);
        }

        String userInput = Console.readLine();

        return userInput;
    }

    static void isValidInput(String userInput, InputType inputType) {
        if (inputType == InputType.BASEBALL_NUMBER) {
            if (userInput.length() != INPUT_BASEBALL_LENGTH) {
                throw new IllegalArgumentException(INPUT_LENGTH_ERROR_MESSAGE);

            }
            if (!isNumeric(userInput)) {
                throw new IllegalArgumentException(INPUT_NOT_NUMERIC_ERROR_MESSAGE);

            }
            if (hasDuplicatedNumber(userInput)) {
                throw new IllegalArgumentException(INPUT_DUPLICATED_ERROR_MESSAGE);

            }
        } else if (inputType == InputType.WILL_REPLAY) {
            if (userInput.length() != INPUT_REPLAY_LENGTH) {
                throw new IllegalArgumentException(INPUT_REPLAY_ERROR_MESSAGE);

            }
            if (!(userInput.charAt(0) == REPLAY || userInput.charAt(0) == END)) {
                throw new IllegalArgumentException(INPUT_REPLAY_ERROR_MESSAGE);

            }
        }
    }

    static boolean isNumeric(String userInput) {
        boolean result = true;
        for (int i = 0; i < 3; ++i) {
            if (!(userInput.charAt(i) >= '1' && userInput.charAt(i) <= '9')) {
                result = false;
                break;

            }
        }

        return result;
    }

    static boolean hasDuplicatedNumber(String userInput) {
        boolean isDuplicated = false;

        char firstLetter = userInput.charAt(0);
        char secondLetter = userInput.charAt(1);
        char thirdLetter = userInput.charAt(2);

        if (firstLetter == secondLetter) {
            isDuplicated = true;

        } else if (firstLetter == thirdLetter) {
            isDuplicated = true;

        } else if (secondLetter == thirdLetter) {
            isDuplicated = true;

        }

        return isDuplicated;
    }

    static int[] stringToIntegerArray(String stringUserInput) {
        int[] input = new int[3];

        for (int i = 0; i < INPUT_BASEBALL_LENGTH; ++i) {
            input[i] = Integer.parseInt(String.valueOf(stringUserInput.charAt(i)));

        }

        return input;
    }

    static int countBalls(int[] userInput, int[] computerNumber) {
        int count = 0;

        for (int i = 0; i < INPUT_BASEBALL_LENGTH; ++i) {
            if (isBall(userInput[i], i, computerNumber)) {
                count += 1;

            }
        }

        return count;
    }

    static boolean isBall(int userInput, int index, int[] computerNumber) {
        for (int i = 0; i < INPUT_BASEBALL_LENGTH; ++i) {
            if (i == index) {
                continue;

            }
            if (userInput == computerNumber[i]) {
                return true;

            }
        }

        return false;
    }

    static int countStrikes(int[] userInput, int[] computerNumber) {
        int count = 0;

        for (int i = 0; i < INPUT_BASEBALL_LENGTH; ++i) {
            if (userInput[i] == computerNumber[i]) {
                count += 1;

            }
        }

        return count;
    }

    static void printResult(int ball, int strike) {
        boolean hasBall = false;
        boolean hasStrike = false;

        StringBuilder result = new StringBuilder();

        if (ball > 0) {
            result.append(ball + BALL_STRING);
            hasBall = true;

        }
        if (strike > 0) {
            if (hasBall) {
                result.append(" ");

            }
            result.append(strike + STRIKE_STRING);
            hasStrike = true;

        }
        if (!(hasBall || hasStrike)) {
            System.out.println(RESULT_NOTHING_MESSAGE);

        } else if (hasBall || hasStrike) {
            System.out.println(result);

        }
    }

    static boolean isThreeStrike(int strike) {
        return strike == MAX_STRIKE;
    }

    static boolean willReplay() {
        boolean replay = false;
        String playOrNot = "";

        playOrNot = getUserInput(InputType.WILL_REPLAY);
        isValidInput(playOrNot, InputType.WILL_REPLAY);

        if (playOrNot.charAt(0) == REPLAY) {
            replay = true;

        }
        return replay;
    }
}

enum InputType {
    BASEBALL_NUMBER,
    WILL_REPLAY
}