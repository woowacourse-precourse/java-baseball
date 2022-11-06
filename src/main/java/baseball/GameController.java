package baseball;

import baseball.playing.PlayGame;

public class GameController {

    public GameController() {
        PlayGame playGame = new PlayGame();

        playGame.startGame();
        playGame.playingGame();
        playGame.endGame();
        playGame.replayGame();
    }

}
