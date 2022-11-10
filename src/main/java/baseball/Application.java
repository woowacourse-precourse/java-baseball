package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computer = new Computer();
        User user = new User();
        Game game = new Game(computer, user, 3);
        game.startGame();
    }
}
