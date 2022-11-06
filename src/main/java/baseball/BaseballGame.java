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
        Boolean isRunning = true;
        List<Integer> computerNumbers = RandomNumberCreator.getRandomNumbers();
        System.out.println(computerNumbers);

        System.out.print(GAME_START_COMMENT);

        while (isRunning) {
            String userInput = getUserInput();

            NumberValidator.checkInput(userInput);

            List<Integer> userNumbers = getNumbersByInput(userInput);

            int ballCount = getBallCount(userNumbers, computerNumbers);
            int strikeCount = getStrikeCount(userNumbers, computerNumbers);

            isRunning = printGameResult(ballCount, strikeCount);
        }

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

    private Boolean printGameResult(int ballCount, int strikeCount) {
        if (strikeCount == STRIKE_NUMBER) {
            return printThreeStrikeResult();
        }
        
        if (strikeCount > ZERO && ballCount > ZERO) {
            return printBallAndStrikeResult(strikeCount, ballCount);
        }

        if (strikeCount > ZERO && ballCount == ZERO) {
            return printStrikeResult(strikeCount);
        }

        if (strikeCount == ZERO && ballCount > ZERO) {
            return printBallResult(ballCount);
        }

        if (strikeCount == ZERO && ballCount == ZERO) {
            return printNothingResult();
        }

        return true;
    }

    private Boolean printBallAndStrikeResult(int strikeCount, int ballCount) {
        System.out.printf(PRINT_BALL_AND_STRIKE, ballCount, strikeCount);

        return true;
    }

    private Boolean printStrikeResult(int strikeCount) {
        System.out.printf(PRINT_STRIKE_COUNT, strikeCount);

        return true;
    }

    private Boolean printBallResult(int ballCount) {
        System.out.printf(PRINT_BALL_COUNT, ballCount);

        return true;
    }

    private Boolean printNothingResult() {
        System.out.print(NOTHING);

        return true;
    }

    private boolean printThreeStrikeResult() {
        System.out.printf(PRINT_STRIKE_COUNT, STRIKE_NUMBER);
        System.out.printf(GAME_TERMINATE, STRIKE_NUMBER);

        return false;
    }

}
