package baseball.logic;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class Randomnumber {
    private List<Integer> randomNum;

    public Randomnumber() {
        randomNum = new ArrayList<>();
    }

    public List<Integer> getNum() {
        return randomNum;
    }

    public void generateNumber() {
        HashSet<Integer> numbers = new LinkedHashSet<>();
        while (numbers.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            numbers.add(number);
        }
        randomNum = new ArrayList<>(numbers);
    }
}
