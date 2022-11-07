package baseball;

import static camp.nextstep.edu.missionutils.Console.*;

public class BaseballGame {

    private final Baseball baseball;

    public BaseballGame() {
        this.baseball = new Baseball();
    }

    void startNewGame() {

        // 1. 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");
        int targetNumber = baseball.createTargetNumber();

        // 2. 사용자에게 숫자 받기
        getUserInput();
    }

    int getUserInput() {
        System.out.println("숫자를 입력해주세요 : ");
        int userInput = Integer.parseInt(readLine());
        return userInput;
    }
}
