package baseball;


public class Application {

    private static final int RESTART = 1;


    public static void main(String[] args) {
        Game game = new Game();


        do {
            game.play();



        } while (RESTART == 2);

    }
}
