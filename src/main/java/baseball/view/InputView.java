package baseball.view;

import baseball.game.Ball;
import baseball.game.Game;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INSERT_BASEBALL_NUMBER_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String NON_NUMBER_INSERT_ERROR_MESSAGE = "[ERROR] 입력은 숫자로만 이루어져야 합니다.";
    private OutputView outputView = new OutputView();

    public Ball getUserBallByConsole() {
        outputView.printMessage(INSERT_BASEBALL_NUMBER_MESSAGE);
        return new Ball(makeIntListByString(Console.readLine()));
    }

    private List<Integer> makeIntListByString(String ballData) {
        try {
            checkStringIsNumber(ballData);
            return ballData.chars().map(ch -> ch - '0').boxed().collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMBER_INSERT_ERROR_MESSAGE);
        }
    }

    private void checkStringIsNumber(String ballData) {
        Integer.parseInt(ballData);
    }
}
