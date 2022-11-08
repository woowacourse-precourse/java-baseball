package baseball;

public class Application {

    public static void main(String[] args) {
        try {
            BaseBallGame baseBallGame = new BaseBallGame();
            baseBallGame.startGame();
        } catch (IllegalArgumentException ie) {
            throw ie;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}