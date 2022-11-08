package baseball;


public class Application {
    public static void main(String[] args) {
        while(true){
            GameManager gameManager = new GameManager();
            GameState GAME_STATE = gameManager.run();
            if(GAME_STATE == GameState.SHUT_DOWN)
                return;
        }
    }
}
