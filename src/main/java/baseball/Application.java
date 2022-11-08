package baseball;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        try {
            gameController.startFirst();
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }
}
