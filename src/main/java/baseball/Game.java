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
}
