package baseball;

import baseball.playing.PlayGame;
import camp.nextstep.edu.missionutils.Console;

public class GameController {

    public GameController() {
        PlayGame playGame = new PlayGame();

            playGame.startGame();
            playGame.playingGame();
            playGame.endGame();
    }



}
