package baseball;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import utils.InputUtils;

public class Game {
    private GameHost gamehost;
    private Player player;
    final private int RESTART_NUMBER = 1;

    public void play() throws IllegalArgumentException {
        startGame();
        playGame();
        if (isGameRestart()) {
            play();
        }
    }

    private boolean isGameRestart() throws IllegalArgumentException {
        int playerInput = isValidPlayerInput();
        return playerInput == RESTART_NUMBER;
    }

    private Integer isValidPlayerInput() throws IllegalArgumentException {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playerInput = Console.readLine();
        if (!InputUtils.isDigit(playerInput) || !InputUtils.isDigitInValidRange(playerInput)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(playerInput);
    }

    private void startGame() {
        this.gamehost = new GameHost();
        this.player = new Player();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void playGame() throws IllegalArgumentException {
        while (true) {
            beingGame();
            if (isGameEnd()) {
                endGame();
                break;
            }
        }
    }

    private void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private boolean isGameEnd() {
        final String ANSWER = "3스트라이크";
        return gamehost.getHint().equals(ANSWER);
    }

    private void beingGame() throws IllegalArgumentException {
        getPlayerBaseballNumber();
        List<Integer> playerInput = player.getBaseballNumber();
        gamehost.setHint(playerInput);
        printHint();
    }

    private void printHint() {
        String hint = gamehost.getHint();
        System.out.println(hint);
    }

    private void getPlayerBaseballNumber() throws IllegalArgumentException {
        System.out.println("숫자를 입력해주세요 :");
        String playerBaseballNumber = Console.readLine();
        player.isValidBaseballNumber(playerBaseballNumber);
        player.setBaseballNumber(InputUtils.changeStringInputToList(playerBaseballNumber));
    }
}

