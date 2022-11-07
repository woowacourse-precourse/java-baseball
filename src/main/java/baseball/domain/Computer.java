package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.util.GameRule.*;

public class Computer {

    private final List<Integer> arbitraryNumbers;

    public Computer() {
        List<Integer> unValidateNumbers = makeArbitraryNumbers();
        this.arbitraryNumbers = unValidateNumbers;
    }

    public List<Integer> getNumbers() {
        return arbitraryNumbers;
    }

    private List<Integer> makeArbitraryNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(INCLUSIVE_START_NUMBER, INCLUSIVE_END_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

}
