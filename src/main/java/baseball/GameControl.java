package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameControl {
    private static final String RESTART_OR_CLOSE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    private static final String RESTART = "1";
    private static final String CLOSE = "2";

    private static final String STATE_ERROR_MESSAGE = "1 또는 2 이외의 값이 포함되어 있습니다. 게임을 종료합니다.";

    private String state;

    public GameControl() {}

    public void play() {
        state = RESTART;
        Computer computer = new Computer();
        BaseballGame baseballGame = new BaseballGame(computer);

        /* 게임 진행 */
        while (state.equals(RESTART)) {
            baseballGame.init();
            baseballGame.playBaseballGame();

            // 야구 게임 재시작 여부 확인
            System.out.println(RESTART_OR_CLOSE_MESSAGE);
            state = readLine();
            validState(state);      // 사용자가 입력한 값 검증
        }

    }

    /* 사용자가 입력한 값 검증 */
    private void validState(String state) {
        if (!state.equals(RESTART) &&
                !state.equals(CLOSE)) {
            throw new IllegalArgumentException(STATE_ERROR_MESSAGE);
        }
    }
}
