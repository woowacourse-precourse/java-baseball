package baseball;

import baseball.unit.Game;
import baseball.unit.ControlGame;


public class Application {

    public static void main(String[] args) {

        ControlGame control = new ControlGame();
        Game game = new Game(control.createComputerNumber());

        while(true){
            if(game.playAndIsNotStrike()) {
                continue;
            }

            if(control.stopGame()){
                break;
            }

            game = new Game(control.createComputerNumber());
        }
    }
}
