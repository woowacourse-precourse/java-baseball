package baseball;

public class Application {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        while(game.getIsContinue()){
            game.play();
        }
    }
}
