package baseball;

public class Application {
    public static void main(String[] args) {
        BaseballGame game = new BaseballGame();
        while(true){
            game.play();
            if(!game.getIsContinue()){
                break;
            }
        }
    }
}
