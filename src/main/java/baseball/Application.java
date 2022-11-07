package baseball;

public class Application {
    public static void main(String[] args) {
        new Game(new ScoreCalculator(), new Reader(), 3).play();
    }
}
