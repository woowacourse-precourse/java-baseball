package baseball;

public class Game {
    private static final String START_STRING = "숫자 야구 게임을 시작합니다.";

    private final Player computer;
    private final Player player;

    public Game() {
        this.computer = new Player();
        this.player = new Player();
    }

    private void init() {
        System.out.println(START_STRING);
    }
}