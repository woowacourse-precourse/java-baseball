package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game(new Player(), new Referee());

        while (game.isPlaying()) {
            game.play();
        }
    }
}
