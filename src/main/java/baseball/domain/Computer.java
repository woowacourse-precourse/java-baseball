package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static baseball.util.GameRule.*;

public class Computer {

    private final List<Integer> arbitraryNumbers;

    public Computer() {
        this.arbitraryNumbers = Randoms.pickUniqueNumbersInRange(INCLUSIVE_START_NUMBER, INCLUSIVE_END_NUMBER, NUMBER_OF_NUMBERS);
    }

    public List<Integer> getNumbers() {
        return arbitraryNumbers;
    }

}
