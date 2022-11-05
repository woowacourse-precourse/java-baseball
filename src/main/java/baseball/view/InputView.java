package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String START_BASEBALL_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_USER_INPUT = "숫자를 입력해주세요 : ";
    private static final String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_END = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void startGame() {
        System.out.println(START_BASEBALL_GAME);
    }

    public String getUserInput() {
        System.out.printf(GAME_USER_INPUT);
        String userBaseballInput = Console.readLine();
        return userBaseballInput;
    }
}
