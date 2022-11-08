package baseball.game;

import baseball.entity.Computer;
import baseball.entity.User;
import baseball.number.NumberJudgment;

import java.util.List;

public class GameService {
    private Computer computer = new Computer();
    private User user = new User();
    private NumberJudgment numberJudgment = new NumberJudgment();

    private int proceed() {
        List<Integer> userNumberList = user.getUserNumberList();
        List<Integer> computerNumberList = computer.getComputerNumberList();

        int strikeCount = 0;
        int sameNumberCount = numberJudgment.getSameNumberCount(computerNumberList, userNumberList);

        if (sameNumberCount == 0) {
            printHint();
        } else {
            strikeCount = numberJudgment.getSameIndexCount(userNumberList);
            int ballCount = sameNumberCount - strikeCount;
            printHint(ballCount, strikeCount);
        }
        return strikeCount;
    }

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
