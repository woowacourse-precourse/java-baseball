package baseball.controller;

import baseball.controller.ground.PlayGround;

import static baseball.controller.GameFlag.START;

public class BaseballController {
    private GameFlag gameFlag;
    private PlayGround playGround;

    public BaseballController() {
        this.gameFlag = START;
    }

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (gameFlag == START) {
            playGround = new PlayGround();
            playGround.playInGround();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
