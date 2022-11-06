package baseball;

import baseball.participants.GameGuider;
import baseball.participants.Hitter;
import baseball.participants.Pitcher;
import baseball.participants.Referee;

public class Application {
    private static GameGuider guider = new GameGuider();
    private static Referee referee = new Referee();
    private static Pitcher pitcher = new Pitcher();
    private static Hitter hitter = new Hitter();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameGuider.guideGameProcess();
        referee.startGame();
        hitter.swing();
        while (referee.toTerminateGame) {
            play1Game();
            referee.playAgainOrNot();
        }
    }

    private static void play1Game() {
        while (referee.isGameInProgress) {
            referee.startPitch();
            pitcher.pitch();
            referee.judge(pitcher.pitchZone, hitter.swingZone);
        }
        referee.endGame();
    }
}
