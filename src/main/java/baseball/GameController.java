package baseball;

import baseball.playing.PlayGame;

public class GameController {

    public GameController() {

        PlayGame playGame = new PlayGame();
        boolean replay = true;

        while (replay) {
            playGame.startGame();
            playGame.playingGame();
            playGame.endGame();
            replay = playGame.replayGame();
        }
    }

}
