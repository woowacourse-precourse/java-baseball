package baseball;

import java.util.Arrays;
import java.util.List;

import static constants.GameConstant.*;
public class BaseballGame {
    private final Player player;
    private final Computer computer;

    public BaseballGame() {
        player = new Player();
        computer = new Computer();
    }

    public void initializeGame() {  //게임 시작 or 재시작 시 호출
        computer.makeComputerNumber();
        playGame();
        checkRestart();
    }

    private void playGame() {
        List<String> playerNumber = Arrays.asList(player.getPlayerNumber().split(""));
        //computer가 player number 검사
        while(computer.isNotThreeStrike(playerNumber)) {
            //checkNumber에서 스트라이크, 볼 개수 & 낫싱여부 판단 후 결과 출력
            computer.checkNumber(playerNumber);
            playerNumber = Arrays.asList(player.getPlayerNumber().split(""));;
        }
        printClearMessage();
    }

    private void printClearMessage() {
        System.out.printf("%d%s%n", GAME_NUMBER_LENGTH, STRIKE_MESSAGE);
        System.out.println(CLEAR_GAME_MESSAGE);
    }

    private void checkRestart() {
        int restartOrEndNumber = player.getRestartOrEndNumber();
        if (restartOrEndNumber == RESTART_NUMBER) {
            initializeGame();
        }
    }
}