package baseball.game;

import baseball.entity.Computer;
import baseball.entity.User;
import baseball.number.NumberJudgment;

public class GameService {
    private Computer computer = new Computer();
    private User user = new User();
    private NumberJudgment numberJudgment = new NumberJudgment();

    private void printHint() {
        System.out.println(Hint.NOTHING.getName());
    }

    private void printHint( int ballCount, int strikeCount) {

        if (ballCount == 0) {
            System.out.println(strikeCount + Hint.STRIKE.getName());
        } else if (strikeCount == 0) {
            System.out.println(ballCount + Hint.BALL.getName());
        } else {
            System.out.println(ballCount + Hint.BALL.getName()+ " " + strikeCount + Hint.STRIKE.getName());
        }
    }

    public enum Hint {
        STRIKE("스트라이크"),
        BALL("볼"),
        NOTHING("낫싱");

        private String name;
        Hint(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
