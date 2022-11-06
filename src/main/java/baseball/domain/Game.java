package baseball.domain;

public class Game {
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    private Computer computer;

    public Game() {
        computer = new Computer();
    }

    public void start() {
        System.out.println(GAME_START_MESSAGE);
        do {
            computer.generateNumber();

        } while(restart);
    }
}
