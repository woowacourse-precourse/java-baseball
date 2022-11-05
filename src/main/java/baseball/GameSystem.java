package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class GameSystem {
    Number number = new Number();
    BallStrikeCheck check = new BallStrikeCheck();

    List computerNumber = number.randomNumber();

    public void startGame() {
        String userNumber = number.userNumber();
        System.out.println(computerNumber);

        int ballStrikeResult = check. ballStrikePrintSet(computerNumber, userNumber);

        if (ballStrikeResult == 0 || ballStrikeResult == 1) {
            startGame();
        } else {
            restart();
        }
    }
}
