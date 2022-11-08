package baseball;

public class Application {

    public static void main(String[] args) {
        try {
            Game.start();
        } catch (IllegalArgumentException illegalArgumentException) {
            throw illegalArgumentException;
        }
    }
}
