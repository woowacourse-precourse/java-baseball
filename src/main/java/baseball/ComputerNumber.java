package baseball;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;
public class ComputerNumber {
    static final int MIN_NUMBER = 1;
    static final int MAX_NUMBER = 9;

    private List<Integer> computerNumber;

    public ComputerNumber() {
        computerNumber = new ArrayList<>();
    }

    public List<Integer> getComputerNumber() {
        return computerNumber;
    }

    public void makeRandomNumber() {
        Set<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < SystemMessage.NUMBER_SIZE) {
            int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            numbers.add(number);
        }
        computerNumber = new ArrayList<>(numbers);
    }
}
