package baseball.service;

import static baseball.message.SystemMessage.*;

import baseball.domain.BaseballMachine;
import baseball.util.Input;

public class BaseballService {

    private BaseballMachine baseballMachine;

    public BaseballService() {
        this.baseballMachine = new BaseballMachine();
    }

    // 인사
    public void welcome() {
        System.out.println(GAME_START_MESSAGE);
    }

    // 게임 초기화 기능
    public void initGame() {
        baseballMachine.prepareGame();
    }

    // 게임 진행 기능
    public void playBaseballGame() {
        System.out.print(INPUT_MESSAGE);
        baseballMachine.matchNumber();
    }

    // 힌트 출력 기능
    public void displayHint() {
        System.out.println(baseballMachine.getHint());
    }

    // 게임 클리어 유무 확인
    public boolean isCorrect() {
        if (baseballMachine.checkAnswer()) {
            System.out.println(GAME_CLEAR_MESSAGE);
            return true;
        }
        return false;
    }

    // 게임 재시작 기능
    public boolean reStart() {
        System.out.println(TRY_AGAIN_MESSAGE);
        String restart = Input.inputUserNumber();
        if (restart.equals(SYSTEM_RESTART)) {
            return true;
        }
        if (restart.equals(SYSTEM_SHUTDOWN)) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
