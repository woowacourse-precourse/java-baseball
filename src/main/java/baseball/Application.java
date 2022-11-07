package baseball;

import baseball.participants.SportsCaster;
import baseball.participants.Hitter;
import baseball.participants.Pitcher;
import baseball.participants.Referee;

public class Application {
    public static void main(String[] args) {
        SportsCaster sportsCaster = new SportsCaster();
        sportsCaster.guideGameProcess();
        while (sportsCaster.willPlay) {
            sportsCaster.startGame();
            playGame();
            sportsCaster.endGame();
            sportsCaster.askToPlayAgain();
        }
        sportsCaster.terminateProgram();
    }

    private static void playGame() {
        Referee referee = new Referee();
        Pitcher pitcher = new Pitcher();
        Hitter hitter = new Hitter();
        hitter.swing();

        while (referee.isGameInProgress) {
            pitcher.pitch();
            referee.judge(pitcher.pitchZone, hitter.swingZone);
        }
    }
}
