package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Computer {
    private static final int CNT = 3;
    private static final int START = 1;
    private static final int END = 9;
    private List<Integer> randNumbers;

    public Computer() {
        randNumbers = new ArrayList<>();
        generateRandom();
    }

    public void generateRandom() {
        while (randNumbers.size() < CNT) {
            int randomNumber = Randoms.pickNumberInRange(START, END);
            if (!randNumbers.contains(randomNumber)) {
                randNumbers.add(randomNumber);
            }
        }
    }

    public List<Integer> getRandNumbers() {
        return randNumbers;
    }

    public boolean isStrike(Integer now, int i) {
        if (randNumbers.get(i) == now) {
            return true;
        }
        return false;
    }

    public boolean isBall(Integer now) {
        if (randNumbers.contains(now)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Computer computer = (Computer) o;
        return Objects.equals(randNumbers, computer.randNumbers);
    }
}
