package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.error.ElementsShouldBeExactly;

import java.util.ArrayList;
import java.util.List;
import baseball.Game;

public class Application {
    public static void GameController() {
        Game game = new Game();
        game.start();
        game.setUserInput();

        while(!game.getGameNums().equals(game.getUserNum())) {
            if(game.isNothing()) {
                game.printNothing();
            }else{
                game.compareNums();
                game.printBallStrike();
            }
            game.setUserInput();
        }

        if(game.getGameNums().equals(game.getUserNum()))
            game.getRightAnswer();
    }

    public static void main(String[] args) {
        GameController();
    }
}
