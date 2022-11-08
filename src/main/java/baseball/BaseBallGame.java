package baseball;

public class BaseBallGame {
    public static final String GAME_START_MENT = "숫자 야구 게임을 시작합니다";

    public BaseBallGame() {
    }

    public void logic() throws IllegalArgumentException {
        Computer computer = new Computer();
        User user = new User();

        System.out.println(GAME_START_MENT);
        computer.createNumList();

        try {
            user.createNumList();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
