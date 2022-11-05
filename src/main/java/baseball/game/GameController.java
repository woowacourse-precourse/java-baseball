package baseball.game;

public class GameController {
    private static GameController instance;

    private  GameController(){}

    public static GameController getInstance() {
        if(instance == null){
            instance = new GameController();
        }

        return instance;
    }

    public Game getBaseBallGame(){
        return new BaseBallGame();
    }

    private class BaseBallGame implements Game{
        @Override
        public void play() {}
    }
}
