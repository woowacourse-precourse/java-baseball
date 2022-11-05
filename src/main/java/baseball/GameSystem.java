package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameSystem {
    Number number = new Number();
    BallStrikeCheck check = new BallStrikeCheck();

    List computerNumber = number.randomNumber();

    public void startGame() {
        String userNumber = number.userNumber();

        int ballStrikeResult = check. ballStrikePrintSet(computerNumber, userNumber);

        if (ballStrikeResult == 0 || ballStrikeResult == 1) {
            startGame();
        } else {
            restart();
        }
    }

    private void restart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String wantRestart = Console.readLine();
        if(wantRestart.equals("1")) {
            computerNumber = number.randomNumber();
            System.out.println("숫자 야구 게임을 시작합니다.");
            startGame();
        }
    }

}
