package baseball;

import baseball.unit.Game;
import baseball.unit.Init;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        Init init = new Init();
        List<Integer> computerNumber = init.createComputerNumber();

        while(true){
            Game game = new Game(computerNumber);
            game.inputGuessNumber();

            if(!game.isAllStrike()) {
                continue;
            }

            if(init.stopGame()){
                break;
            }

            computerNumber = init.createComputerNumber();
        }
    }
}
