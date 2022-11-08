package baseball;

import baseball.participants.Game;
import baseball.participants.SportsCaster;

/**
 * 숫자 야구 게임 어플리케이션을 실행합니다.
 */
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
