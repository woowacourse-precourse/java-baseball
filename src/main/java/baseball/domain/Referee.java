package baseball.domain;

import java.util.List;
import java.util.Objects;

public class Referee {
    private static final int RESTART = 1;
    private static final int STOP = 2;
    private Computer computer;

    public Referee(Computer computer) {
        this.computer = computer;
    }

    public Number judge(String userNumber) {
        Number number = new Number();
        for (int i = 0; i < Validator.CNT; i++) {
            Integer now = Character.getNumericValue(userNumber.charAt(i));
            if (computer.isStrike(now, i)) {
                number.hitStrike();
                continue;
            }
            if (computer.isBall(now)) {
                number.hitBall();
            }
        }

        return number;
    }


    public Computer getComputer() {
        return computer;
    }

    public void reset() {
        this.computer = new Computer();
    }

    public boolean judgeRestart(String inputMessage) {
        int exitMessage = Integer.valueOf(inputMessage);
        if (exitMessage == RESTART) {
            return true;
        }

        if (exitMessage == STOP) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Referee referee = (Referee) o;
        return Objects.equals(computer, referee.computer);
    }
}
