package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballGame {
    private static final String GAME_START_COMMENT = "숫자 야구 게임을 시작합니다.\n";
    private static final String NUMBER_INPUT_COMMENT = "숫자를 입력해주세요 : ";
    private static final char INTEGER_MAKER = '0';

    public void playGame() throws IllegalArgumentException {
        System.out.print(GAME_START_COMMENT);
        String userInput = getUserInput();
        NumberValidator.checkInput(userInput);
        List<Integer> numbers = getNumbersByInput(userInput);
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
}
