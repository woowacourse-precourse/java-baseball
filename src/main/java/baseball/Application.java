package baseball;

public class Application {
    public static void main(String[] args) {
        Game_function Game = new Game_function();
        while(Game.play == 1){
            Game.play();
        }
        Game.end();
    }
}
