package baseball.domain;

import baseball.view.Output;

public class Game {
    private final static int RESTART = 1;

    private final Player player;
    private final Computer computer;

    public Game() {
        this.player = new Player();
        this.computer = new Computer();
    }

    public void run() {
        computer.setForNewGame();

        while(!computer.isStruckOut()) {
            computer.provideHintTo(player);
        }
        Output.printGameClear();
    }

    public boolean dosePlayerWantNewGame() {
        return player.chooseRestartOrExit() == RESTART;
    }
}
