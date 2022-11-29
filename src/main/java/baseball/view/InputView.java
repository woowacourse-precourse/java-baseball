package baseball.view;

import baseball.decision.Decision;
import baseball.game.Ball;
import baseball.game.Game;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String INSERT_BASEBALL_NUMBER_MESSAGE = "숫자를 입력해 주세요 : ";
    private static final String INSERT_GAME_COMMAND_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String NON_NUMBER_INSERT_ERROR_MESSAGE = "[ERROR] 입력은 숫자로만 이루어져야 합니다.";
    private static final String INVALID_NUMBER_INSERT_ERROR_MESSAGE = "[ERROR]: 입력해야 하는 ball의 크기는 %d입니다.";
    private OutputView outputView = new OutputView();

    public Ball getUserNBallByConsole(int ballSize) {
        System.out.printf(INSERT_BASEBALL_NUMBER_MESSAGE);
        List<Integer> ballData = makeIntListByString(Console.readLine());
        ballSizeValidation(ballSize, ballData);
        return new Ball(ballData);
    }

    public Decision getUserCommandByConsole() {
        outputView.printMessage(INSERT_GAME_COMMAND_MESSAGE);
        String userInput = Console.readLine();
        numberValidation(userInput);
        return Decision.getDecisionByNumber(Integer.parseInt(userInput));
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

    private void ballSizeValidation(int ballSize, List<Integer> ballData) {
        if (ballSize != ballData.size()) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_INSERT_ERROR_MESSAGE, ballSize));
        }
    }

    private void numberValidation(String data) {
        Integer.parseInt(data);
    }
}
