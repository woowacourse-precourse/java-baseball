package baseball.participants;

/**
 * 숫자 야구 게임을 진행합니다.
 */
public class Game {
    Referee referee;
    Pitcher pitcher;
    Hitter hitter;

    public Game() {
    }

    public void play() {
        referee = new Referee();
        pitcher = new Pitcher();
        hitter = new Hitter();

        hitter.swing();
        while (!referee.doesPitcherWin()) {
            playInning();
        }
    }

    private void playInning() {
        pitcher.pitch();
        referee.judge(pitcher.pitchZone, hitter.swingZone);
    }
}
