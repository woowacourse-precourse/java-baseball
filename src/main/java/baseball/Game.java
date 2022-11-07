package baseball;

import java.util.List;
import java.util.Scanner;

import utils.InputUtils;

public class Game {
    private boolean gameStatus;
    private final String ERROR_MESSAGE = "1과 2중 하나만 입력하세요";
    private GameHost gamehost;
    private Player player;
    private final Scanner scanner;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void play() {
        while (true) {
            startGame();
            beingGame();
            boolean isrestart = isGameRestart();
            if (!isrestart) {
                break;
            }
        }
    }

    public boolean getGameStatus() {
        return this.gameStatus;
    }

    public boolean isGameRestart() {
        while (true) {
            int playerInput;
            try {
                playerInput = isValidPlayerInput();
            } catch (IllegalArgumentException exception) {
                continue;
            }
            return playerInput == 1;
        }
    }

    public Integer isValidPlayerInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String playerInput = scanner.nextLine();

        if (!InputUtils.isDigit(playerInput) || !InputUtils.isDigitInValidRange(playerInput)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(playerInput);
    }

    public void startGame() {
        this.gameStatus = true;
        this.gamehost = new GameHost();
        this.player = new Player();
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public boolean isGameEnd(String hint) {
        return hint.equals("3스트라이크");
    }

    public void beingGame() {
        while (true) {
            String playerBaseballNumber = getPlayerBaseballNumber();
            try {
                player.isValidBaseballNumber(playerBaseballNumber);
            } catch (IllegalArgumentException exception) {
                continue;
            }

            List<Integer> playerInput = player.getBaseballNumber();
            gamehost.setHint(playerInput);
            String hint = gamehost.getHint();
            System.out.println(hint);

            if (isGameEnd(hint)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

    public String getPlayerBaseballNumber() {
        System.out.println("숫자를 입력해주세요 :");
        return scanner.nextLine();
    }
}

