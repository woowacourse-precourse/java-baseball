package baseball;

public class Application {
    public static void main(String[] args) {
        boolean game_cont = true;
        while(game_cont){
            game_cont = GameDealer.ONE_GAME(args);
        }
    }
}

