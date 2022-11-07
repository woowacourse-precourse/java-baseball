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

}
