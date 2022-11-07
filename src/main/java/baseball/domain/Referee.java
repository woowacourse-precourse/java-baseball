package baseball.domain;

import java.util.List;
import java.util.Objects;

public class Referee {
    private Computer computer;
    private static final int CNT = 3;

    public Referee(Computer computer) {
        this.computer = computer;
    }

    public Number judge(String userNumber) {
        List<Integer> answer = computer.getRandNumbers();
        Number number = new Number();

        for (int i = 0; i < CNT; i++) {
            Integer now = Character.getNumericValue(userNumber.charAt(i));
            if (now == answer.get(i)) {
                number.hitStrike();
                continue;
            }
            if (answer.contains(now)) {
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
        if (exitMessage == 1) {
            return true;
        }

        if (exitMessage == 2) {
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
