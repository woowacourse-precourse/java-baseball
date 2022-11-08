package baseball.controller;

import baseball.controller.ground.PlayGround;
import baseball.domain.input.ConsoleInputReader;

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

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
            gameFlag = ConsoleInputReader.getUserOpinion();
        }
        System.out.println("숫자 야구 게임을 종료합니다.");
    }
}
