package baseball.view;

import baseball.domain.BaseballGameStatus;
import camp.nextstep.edu.missionutils.Console;

public enum InputView {
    INSTANCE;

    private static final String INPUT_BASEBALL_NUMBER = "숫자를 입력해주세요 : ";
    private static final String INPUT_GAME_STATUS = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String inputBaseballNumber() {
        System.out.print(INPUT_BASEBALL_NUMBER);
        String baseballNumber = Console.readLine();

        InputValidator.validateBaseballNumber(baseballNumber);

        return baseballNumber;
    }

    public BaseballGameStatus inputGameStatus() {
        System.out.println(INPUT_GAME_STATUS);
        String gameStatus = Console.readLine();

        InputValidator.validateGameStatus(gameStatus);

        return BaseballGameStatus.getEnum(Integer.valueOf(gameStatus));
    }
}
