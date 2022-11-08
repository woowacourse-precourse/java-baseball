package baseball.controller;

import baseball.service.Service;
import baseball.service.ServiceImpl;
import baseball.utils.GetInput;

public class Controller {
    GetInput getInput = new GetInput();
    Service service = new ServiceImpl();
    public Controller() {
    }
    public void playGame() {
        System.out.println("숫자 야구 게임을 시작합니다");
        service.readyGame();
        playNextGame();
    }
    public void playNextGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int inputNumber = getInput.getInput();
        if (inputNumber == 1) {
            this.playGame();
        } else if (inputNumber != 2) {
            throw new IllegalArgumentException();
        }
    }
}
