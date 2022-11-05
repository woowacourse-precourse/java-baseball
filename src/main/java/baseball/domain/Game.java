package baseball.domain;

import java.util.ArrayList;

public class Game {
    private final static int THREE_STRIKES = 3;
    private final static int RESTART = 1;
    private final static Player player = new Player();

    private final Computer computer;

    Game() {
        this.computer = new Computer();
    }

    private void run() {
        boolean isGameCleared = false;
        while(!isGameCleared) {
            ArrayList<Integer> playerGuess = player.guessNumbers();
            int strikeCount = computer.provideHint(playerGuess);
            isGameCleared = (strikeCount == THREE_STRIKES);
        }
        Output.printGameClear();
    }

    private boolean askPlayerForRestart() {
        return player.chooseRestartOrExit() == RESTART;
    }

    private static boolean playNewGame() {
        Game game = new Game();
        game.run();
        return game.askPlayerForRestart();
    }

    public static void play() {
        boolean needNewGame = true;
        while (needNewGame) {
            needNewGame = playNewGame();
        }
    }
}
