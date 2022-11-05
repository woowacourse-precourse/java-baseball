package baseball;

public class Application {
    public static void main(String[] args) {
        GameManager manager = new GameManager(
                new Computer(),
                new Player()
        );
        manager.run();
    }
}
