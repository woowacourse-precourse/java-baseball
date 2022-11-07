package baseball;

import baseball.participants.Game;
import baseball.participants.SportsCaster;


public class Application {
    public static void main(String[] args) {
        SportsCaster sportsCaster = new SportsCaster();
        Game game = new Game();
        sportsCaster.guideGameProcess();
        while (sportsCaster.willPlay) {
            sportsCaster.startGame();
            game.play();
            sportsCaster.endGame();
            sportsCaster.askToPlayAgain();
        }
        sportsCaster.terminateProgram();
    }
}
