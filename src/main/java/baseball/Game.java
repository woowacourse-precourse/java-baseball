package baseball;

public class Game {
    private final Computer computer;
    private final User user;

    private Game(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
    }

    public static Game start(User user) {
        Computer computer = Computer.generateAnswer();
        return new Game(computer, user);
    }

    String hint(int strike, int ball) {
        StringBuilder hint = new StringBuilder();
        if (ball > 0) {
            hint.append(ball).append("볼 ");
        }
        if (strike > 0) {
            hint.append(strike).append("스트라이크 ");
        }
        if (hint.length() == 0) {
            hint.append("낫싱");
        }
        return hint.toString().trim();
    }
}
