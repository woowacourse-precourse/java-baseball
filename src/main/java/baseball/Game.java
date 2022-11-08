package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashMap;

public class Game {
    public Computer computer;
    public Judge judge;

    public Game() {
        computer = new Computer();
        judge = new Judge();
    }

    public void play() {
        printGameStartMessage();
        LinkedHashMap<Integer, Integer> computerNumbers = computer.pickNumbers();
        LinkedHashMap<Integer, Integer> playerNumbers;
        while (true) {
            PlayerNumber playerNumber = new PlayerNumber();
            playerNumbers = playerNumber.pickNumbers();
            if (judge.printGameOver(computerNumbers, playerNumbers)) {
                printGameOverMessage();
                break;
            }
        }
    }

    private void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void printGameOverMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean askRetry() {
        printAskRetryMessage();
        if (getInputNumber() == GameConstant.RETRY) {
            Game game = new Game();
            game.play();
        }
        return false;
    }

    private void printAskRetryMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static int getInputNumber() {
        int inputNumber = Integer.parseInt(Console.readLine());
        if (!isValidated(inputNumber)) {

        }
        return inputNumber;
    }

    public static boolean isValidated(int inputNumber) {
        if ((inputNumber != GameConstant.RETRY) && (inputNumber != GameConstant.EXIT)) {
            throw new IllegalArgumentException("잘못된 입력값입니다. 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        }
        return true;
    }
}
