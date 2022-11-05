package baseball;

import static constants.GameConstant.*;
public class BaseballGame {
    private final Player player;
    private final Computer computer;

    public BaseballGame() {
        player = new Player();
        computer = new Computer();
    }

    public void initializeGame() {
        computer.makeComputerNumber();
        playGame();
        checkRestart();
    }

    private void playGame() {
        while(isNotThreeStrike) {
            //game 유지 코드 작성
        }
        printClearMessage();
    }

    private void printClearMessage() {
        System.out.println(CLEAR_GAME_MESSAGE);
    }

    private void checkRestart() {
        int restartOrEndNumber = player.getRestartOrEndNumber();
        if (restartOrEndNumber == RESTART_NUMBER) {
            initializeGame();
        }
    }
}