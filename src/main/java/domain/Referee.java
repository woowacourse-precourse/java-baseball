package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Referee {

    private final Computer computer;
    private final User user;
    private int strike = 0;
    private int ball = 0;
    private static final int MAXIMUM_NUMBER_INPUT = 3;
    private static final int MAXIMUM_SET_SIZE = 6;

    public Referee(Computer computer, User user) {
        this.computer = computer;
        this.user = user;
    }

    public void judge() {
        Set<Integer> judgeSet = new HashSet<>();

        List<Integer> computerNumbers = computer.getNumbers();
        List<Integer> userNumbers = user.getVerifiedValueList();

        for (int i = 0; i < MAXIMUM_NUMBER_INPUT; i++) {
            if (Objects.equals(computerNumbers.get(i), userNumbers.get(i))) {
                strike++;
            }

            judgeSet.add(computerNumbers.get(i));
            judgeSet.add(userNumbers.get(i));
        }

        this.ball = MAXIMUM_SET_SIZE - judgeSet.size() - this.strike;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void init() {
        this.strike = 0;
        this.ball = 0;
    }

}
