package baseball;

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
}
