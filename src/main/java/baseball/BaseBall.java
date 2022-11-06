package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBall {

    public void start() {
        // 시작 문구 입력
        printStartingGuide();
        // 게임 시작
        Game game = new Game();
        game.start();
    }

    private void printStartingGuide() {
        System.out.println("숫자 아구 게임을 시작합니다.");
    }

}
