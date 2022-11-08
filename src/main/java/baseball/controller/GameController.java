package baseball.controller;

import baseball.domain.Hint;
import baseball.service.ComputerService;
import baseball.service.HintService;
import baseball.service.PlayerService;
import baseball.view.InputView;

import java.util.List;

public class GameController {
    public static void playBaseballGame() {
        do {
            startGame();
        } while(!finishGame());
    }

    public static void startGame() {
        List<Integer> computerNumber = ComputerService.generateComputerNumber();//랜덤 수 생성

        while(true) {
            String number = InputView.scanNumber();
            List<Integer> playerNumber = PlayerService.generatePlayerNumber(number); //플레이어 숫자

            if (isAnswer(computerNumber, playerNumber)) {
                break;
            }
        }
    }

    public static Boolean isAnswer(List<Integer> computerNumber, List<Integer> playerNumber) {
        Hint hint = HintService.generateHint(computerNumber, playerNumber);

        if (hint.getStrike() == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else {
            System.out.println(hint.getBall() + "볼 " + hint.getStrike() + "스트라이크");
            return false;
        }
    }

    public static Boolean finishGame() {

        return null;
    }
}
