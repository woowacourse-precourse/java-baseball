package baseball.model;

import baseball.view.Input;

public class Player {
    private String baseballNumber;

    // 숫자 입력하기
    private Input input = new Input();

    public void setBaseballNumber() {
        this.baseballNumber = input.threeNumber();
    }

    public String getBaseballNumber() {
        return baseballNumber;
    }

    // 게임 계속 또는 종료 선택하기
    public boolean continueGame() {
        return input.continueGame();
    }
}
