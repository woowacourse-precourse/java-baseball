package baseball;

public class Application {
    public static void main(String[] args) {
        Game game;
        Game.title();
        
        do {
            game = new Game();

            game.play();

            if(!game.replay()) { game = null; };

        } while(game != null);
    }
}
