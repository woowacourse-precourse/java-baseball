package baseball;

public class ProgramAssembler {
    Player player;
    Computer computer;

    ProgramAssembler() {
        this.player = new Player();
        this.computer = new Computer();
    }

    public void start() {
        do {
            play();
        } while (player.wantRestart());
    }

    public void play() {
        computer.generateRandomNumber();
        do {
            computer.countScore(player.getPlayerInputNum());
            computer.printScore();
        } while (!computer.isGameOver());
    }
}
