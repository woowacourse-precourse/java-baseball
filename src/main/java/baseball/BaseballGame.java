package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static final String GAME_START_COMMENT = "숫자 야구 게임을 시작합니다.\n";
    private static final String NUMBER_INPUT_COMMENT = "숫자를 입력해주세요 : ";
    private static final String PRINT_BALL_AND_STRIKE = "%d볼 %d스트라이크\n";
    private static final String PRINT_STRIKE_COUNT = "%d스트라이크\n";
    private static final String PRINT_BALL_COUNT = "%d볼\n";
    private static final String NOTHING = "낫싱\n";
    private static final String GAME_TERMINATE = "%d개의 숫자를 모두 맞히셨습니디! 게임 종료\n";

    private static final char INTEGER_MAKER = '0';
    private static final int STRIKE_NUMBER = 3;
    private static final int ZERO = 0;

    public void playGame() throws IllegalArgumentException {
        System.out.print(GAME_START_COMMENT);
        String userInput = getUserInput();

        NumberValidator.checkInput(userInput);

        List<Integer> computerNumbers = RandomNumberCreator.getRandomNumbers();
        List<Integer> userNumbers = getNumbersByInput(userInput);

        int ballCount = getBallCount(userNumbers, computerNumbers);
        int strikeCount = getStrikeCount(userNumbers, computerNumbers);

        printGameResult(ballCount, strikeCount);
    }

    public String getUserInput() {
        System.out.print(NUMBER_INPUT_COMMENT);
        return Console.readLine();
    }

    private List<Integer> getNumbersByInput(String userInput) {
        List<Integer> numbers = new ArrayList<>();

        for (int index = 0; index < userInput.length(); index++) {
            char number = userInput.charAt(index);
            numbers.add(number - INTEGER_MAKER);
        }

        return numbers;
    }

    private int getBallCount(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int ballCount = 0;
        for (int userIndex = 0; userIndex < userNumbers.size(); userIndex++) {
            for (int computerIndex = 0; computerIndex < computerNumbers.size(); computerIndex++) {
                ballCount += getEachBallCount(userNumbers, computerNumbers, userIndex, computerIndex);
            }
        }
        return ballCount;
    }

    private int getEachBallCount(List<Integer> userNumbers, List<Integer> computerNumbers, int userIndex, int computerIndex) {
        int userNumber = userNumbers.get(userIndex);
        int computerNumber = computerNumbers.get(computerIndex);

        if (userNumber == computerNumber && userIndex != computerIndex) {
            return 1;
        }

        return 0;
    }

    private int getStrikeCount(List<Integer> userNumbers, List<Integer> computerNumbers) {
        int strikeCount = 0;
        for (int userIndex = 0; userIndex < userNumbers.size(); userIndex++) {
            for (int computerIndex = 0; computerIndex < computerNumbers.size(); computerIndex++) {
                strikeCount += getEachStrikeCount(userNumbers, computerNumbers, userIndex, computerIndex);
            }
        }
        return strikeCount;
    }

    private int getEachStrikeCount(List<Integer> userNumbers, List<Integer> computerNumbers, int userIndex, int computerIndex) {
        int userNumber = userNumbers.get(userIndex);
        int computerNumber = computerNumbers.get(computerIndex);

        if (userNumber == computerNumber && userIndex == computerIndex) {
            return 1;
        }

        return 0;
    }

    private void printGameResult(int ballCount, int strikeCount) {
        if (strikeCount > ZERO && ballCount > ZERO) {
            printBallAndStrikeResult(strikeCount, ballCount);
        }

        if (strikeCount > ZERO && ballCount == ZERO) {
            printStrikeResult(strikeCount);
        }

        if (strikeCount == ZERO && ballCount > ZERO) {
            printBallResult(ballCount);
        }

        if (strikeCount == ZERO && ballCount == ZERO) {
            printNothingResult();
        }

        if (strikeCount == STRIKE_NUMBER) {
            printThreeStrikeResult();
        }
    }

    private void printBallAndStrikeResult(int strikeCount, int ballCount) {
        System.out.printf(PRINT_BALL_AND_STRIKE, ballCount, strikeCount);
    }

    private void printStrikeResult(int strikeCount) {
        System.out.printf(PRINT_STRIKE_COUNT, strikeCount);
    }

    private void printBallResult(int ballCount) {
        System.out.printf(PRINT_BALL_COUNT, ballCount);
    }

    private void printNothingResult() {
        System.out.print(NOTHING);
    }

    private void printThreeStrikeResult() {
        System.out.printf(PRINT_STRIKE_COUNT, STRIKE_NUMBER);
        System.out.printf(GAME_TERMINATE, STRIKE_NUMBER);
    }

}
