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
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.generateNumber();
        do {
            user.selectUserNumber();
        } while (gameProcessor.isThreeStrike(computer.getComputerNumbers(), user.getUserInputNumbers()));
    }
}
