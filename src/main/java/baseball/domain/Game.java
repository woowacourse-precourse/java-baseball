package baseball.domain;

import java.util.ArrayList;

public class Game {
    private final static int THREE_STRIKES = 3;
    private final static int RESTART = 1;

    private final Player player;
    private final Computer computer;

    public Game() {
        this.player = new Player();
        this.computer = new Computer();
    }

    public void run() {
        computer.setStrikeNumbers();
        boolean isGameCleared = false;

        while(!isGameCleared) {
            int roundResult = playTheNextRound();
            isGameCleared = (roundResult == THREE_STRIKES);
        }
        Output.printGameClear();
    }

    private int playTheNextRound() {
        ArrayList<Integer> playerGuess = player.guessNumbers();
        return computer.provideHint(playerGuess);
    }

    public boolean dosePlayerWantNewGame() {
        return player.chooseRestartOrExit() == RESTART;
    }
}
