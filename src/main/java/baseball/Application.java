package baseball;

public class Application {

    private static int start = 1;

    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        while(start!=2){
            start = game.GameStart();
        }

    }
}
