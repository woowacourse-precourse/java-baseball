package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static final String GAME_START_COMMENT = "숫자 야구 게임을 시작합니다.\n";
    private static final String NUMBER_INPUT_COMMENT = "숫자를 입력해주세요 : ";
    private static final char INTEGER_MAKER = '0';

    public void playGame() throws IllegalArgumentException {
        System.out.print(GAME_START_COMMENT);
        String userInput = getUserInput();

        NumberValidator.checkInput(userInput);

        List<Integer> computerNumbers = RandomNumberCreator.getRandomNumbers();
        List<Integer> userNumbers = getNumbersByInput(userInput);

        int ballCount = getBallCount(userNumbers, computerNumbers);
        int strikeCount = getStrikeCount(userNumbers, computerNumbers);
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

}
