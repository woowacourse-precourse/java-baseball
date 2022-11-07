package baseball;

public class Application {

    public static void main(String[] args) {
        boolean replay = true;
        while (replay) {
            Game.startGame();
            Output.endMessage();
            replay = Input.inputReplay();
        }
    }
}
