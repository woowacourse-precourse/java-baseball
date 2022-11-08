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

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public List<Integer> getComputerNumber() {
        List<Integer> computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }

    public void askPlayerToInputNumber() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public List<Integer> getPlayerNumber() {
        List<Integer> playerNumber = new ArrayList<>();
        String inputNumber = Console.readLine();
        if (isPlayerNumberException(inputNumber)){
            throw new IllegalArgumentException();
        }
        for (int i=0; i<inputNumber.length(); i++) {
            int currentDigit = Character.getNumericValue(inputNumber.charAt(i));
            playerNumber.add(currentDigit);
        }
        return playerNumber;
    }
}
