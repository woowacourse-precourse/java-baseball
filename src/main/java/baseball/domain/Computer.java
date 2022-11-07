package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    private List<Integer> computerNumbers;

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }

    public void generateNumber() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 3) {
            numbers.add(Randoms.pickNumberInRange(1, 9));
        }
        computerNumbers = List.copyOf(numbers);
    }
}
