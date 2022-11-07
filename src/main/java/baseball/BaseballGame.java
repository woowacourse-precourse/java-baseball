package baseball;

import camp.nextstep.edu.missionutils.Console;

public class BaseballGame extends Game {
    private final int NUMBER_LIMIT = 3;
    private final int RESTART_NUMBER = 1;
    private final int CLOSE_NUMBER = 2;
    private final String GREETING_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String CLOSE_MESSAGE = NUMBER_LIMIT + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String NOTHING_MESSAGE = "낫싱";
    private final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private boolean isFirst = true;

    @Override
    protected void greet() {
        System.out.println(GREETING_MESSAGE);
    }

    @Override
    protected void play() {

    }

    @Override
    protected void close() {
        System.out.println(CLOSE_MESSAGE);
    }

    @Override
    protected boolean restart() {
        if (isFirst) {
            isFirst = false;
            return true;
        }
        System.out.println(RESTART_MESSAGE);
        int input = Integer.parseInt(Console.readLine());

        return input == RESTART_NUMBER;
    }
}
