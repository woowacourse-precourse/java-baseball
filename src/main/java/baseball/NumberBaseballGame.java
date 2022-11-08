package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberBaseballGame {
    public void startGame() {
        boolean start = true;
        while (start) {
            int strike = 0;
            int ball = 0;
            int restartNumber;
            List<Integer> computerNumber;
            List<Integer> playerNumber;

            printStartMessage();
            computerNumber = getComputerNumber();
            while (strike != 3) {
                askPlayerToInputNumber();
                playerNumber = getPlayerNumber();
                strike = calculateStrikeAndBall(computerNumber, playerNumber).get(0);
                ball = calculateStrikeAndBall(computerNumber, playerNumber).get(1);
                printResultMessage(strike, ball);
            }
            printEndMessage();
            printRestartMessage();
            restartNumber = getRestartNumber();
            start = judgeRestart(restartNumber);
        }
    }

    private void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
