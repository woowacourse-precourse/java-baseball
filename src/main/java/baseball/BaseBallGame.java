package baseball;

public class BaseBallGame {

    private final Computer computer;
    private final User user;
    private final GameProcessor gameProcessor;

    public BaseBallGame() {
        this.user = new User();
        this.computer = new Computer();
        this.gameProcessor = new GameProcessor();
    }

    public void run() {
        OutputView.printStartMessage();
        computer.generateNumber();
        do {
            user.selectUserNumber();
        } while (gameProcessor.isThreeStrike(computer.getComputerNumbers(), user.getUserInputNumbers()));
    }
}
