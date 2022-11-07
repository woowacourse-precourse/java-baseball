package baseball.service;

import baseball.domain.BaseballCount;
import baseball.util.Input;

import static baseball.message.BaseballMessage.*;

public class BaseballService {
    private BaseballCount baseballCount;

    public BaseballService() {}

    // 인삿말 출력
    public void hello() {
        System.out.println(WELCOME_MESSAGE);
    }

    // 게임 초기화
    public void initGame() {
        this.baseballCount = new BaseballCount();
    }

    // 게임 진행
    public void playGame() {
        System.out.print(NUMBER_INPUT_MESSAGE);
        baseballCount.playGame();
        System.out.println(baseballCount.displayHint());
    }

    //정답을 맞췄는지 확인여부에 따른 메세지 출력 기능
    public boolean isCorrect() {
        if (baseballCount.isCorrect()) {
            System.out.println(STRIKE_END_MESSAGE);
            System.out.println(RESTART_OR_END_MESSAGE);
            return true;
        }
        return false;
    }

    //사용자가 게임을 재시작하는지 확인하는 기능
    public Boolean isRestart() {
        String input = Input.input();
        if (input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException();
    }

}
