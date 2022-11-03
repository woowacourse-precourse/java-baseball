package baseball;

import baseball.user.Input;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

/**
 * 게임의 전반적인 기능을 하는 클래스
 */
public class Game {

    Input input = new Input();

    public Game() {
    }

    /**
     * 사용자의 입력을 받아 List로 변환해 넘겨주는 메소드
     * @return 숫자를 차례로 넣은 List
     */
    public List<Integer> getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");

        String userInput = Console.readLine();

        if (!input.isAllDigits(userInput)
                || !input.isAllDifferentDigit(userInput)
                || !input.isDigitsInRange(userInput)
                || !input.isInputLengthEqualsGameLength(userInput)) {
            throw new IllegalArgumentException();
        }

        return input.inputDigit(userInput);
    }
}
