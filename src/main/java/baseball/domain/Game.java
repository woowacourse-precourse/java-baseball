package baseball.domain;

import baseball.view.Output;

public class Game {
    private final Player player;
    private final Computer computer;

    public Game(Player player) {
        this.player = player;
        this.computer = new Computer();
    }

    public void run() {
        computer.setForNewGame();

        while (!computer.isStruckOut()) {
            computer.provideHintTo(player);
        }
        Output.printGameClear();
        player.chooseRestartOrExit();
    }
}
