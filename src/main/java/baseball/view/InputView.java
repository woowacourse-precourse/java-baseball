package baseball.view;

import baseball.model.GameNumber;
import camp.nextstep.edu.missionutils.Console;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    GameNumber gameNumber = new GameNumber();

    public void enterGameNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        String inputNumber = Console.readLine();

        gameNumber.setInputString(inputNumber);
    }
}
