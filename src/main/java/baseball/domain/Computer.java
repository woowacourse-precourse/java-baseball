package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Computer {
    private List<Integer> randNumbers;

    public Computer() {
        randNumbers = new ArrayList<>();
        generateRandom();
    }

    public void generateRandom() {
        while (randNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randNumbers.contains(randomNumber)) {
                randNumbers.add(randomNumber);
            }
        }
    }

    public List<Integer> getRandNumbers() {
        return randNumbers;
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
}
