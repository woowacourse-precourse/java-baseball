package baseball;


public class Application {

    private static final int RESTART = 1;


    public static void main(String[] args) {
        Game game = new Game();
        String isRestart;

        do {
            isRestart = game.play();



        } while (Integer.parseInt(isRestart) == RESTART);

    }
}
