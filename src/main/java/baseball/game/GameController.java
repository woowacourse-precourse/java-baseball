package baseball.game;

import baseball.entity.Computer;

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
        Computer computer;

        public BaseBallGame() {
            computer = new Computer();
        }

        private void initialize(){
            computer.initialize();
        }

        @Override
        public void play() {
            initialize();
        }
    }
}
