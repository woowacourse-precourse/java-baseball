package game.stdiogame.numberbaseball;

import camp.nextstep.edu.missionutils.Console;
import game.Game;
import game.GameManager;
import game.GameStatus;

public class NumberBaseballStdIOGameManager implements GameManager {
    private final Game game;
    private static final NumberBaseballStdIOGameManager INSTANCE = new NumberBaseballStdIOGameManager();
    private NumberBaseballStdIOGameManager() {
        GameStatus gameStatus = new NumberBaseballStdIOGameStatus();
        game = new NumberBaseballStdIOGame("숫자 야구 게임", gameStatus);
    }

    public static NumberBaseballStdIOGameManager getInstance() {
        return INSTANCE;
    }

    @Override
    public void restartGame() {
        NumberBaseballStdIOGame game = (NumberBaseballStdIOGame) this.game;
        NumberBaseballStdIOGameStatus gameStatus = (NumberBaseballStdIOGameStatus) game.getGameStatus();
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String line = Console.readLine();
        if (line.equals("1")) {
            gameStatus.setStart(true);
            gameStatus.setFinish(false);
            gameStatus.changeTargetNumbers();
        } else if (!line.equals("2")) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void startGame() {
        game.start();
        System.out.println(((NumberBaseballStdIOGame)game).getName() + "을 시작합니다.");
        while (doesGameStart()) {
            game.loop();
            restartGame();
        }
    }

    @Override
    public boolean doesGameStart() {
        return ((NumberBaseballStdIOGame)game).getGameStatus().isStart();
    }

    @Override
    public boolean doesGameFinish() {
        return ((NumberBaseballStdIOGame)game).getGameStatus().isFinish();
    }

    public Game getGame() {
        return game;
    }
}
