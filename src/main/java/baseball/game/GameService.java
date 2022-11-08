package baseball.game;

import baseball.entity.Computer;
import baseball.entity.User;
import baseball.number.NumberJudgment;

public class GameService {
    private Computer computer = new Computer();
    private User user = new User();
    private NumberJudgment numberJudgment = new NumberJudgment();

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
