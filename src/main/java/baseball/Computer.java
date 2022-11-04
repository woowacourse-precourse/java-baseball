package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {

    private List<Integer> numbers;

    public Computer() {}

    public void setNumbers() {
        Set<Integer> numbersSet = new HashSet<>();
        while(numbersSet.size() < 3) {
            numbersSet.add(Randoms.pickNumberInRange(1,9));
        }
        setToArrayList(numbersSet);
        numberShuffle(this.numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public void numberShuffle(List<Integer> lst) {
        this.numbers = Randoms.shuffle(lst);
    }

    public void setToArrayList(Set<Integer> set) {
        this.numbers = new ArrayList<>(set);
    }
}
