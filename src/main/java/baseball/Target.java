package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Target {
    private static final int CHECK_VALUE = -1;

    private final List<Integer> targetValue;

    public Target() {
        this.targetValue = mapToList(getRandomLinkedHashSet());
    }

    //테스트를 위해 public으로 선언
    private Target(List<Integer> targetValue) {
        this.targetValue = new ArrayList<>(targetValue);
    }

    public Target copy() {
        return new Target(this.targetValue);
    }

    public Integer get(int index) {
        return targetValue.get(index);
    }

    public boolean isContain(Integer element) {
        return targetValue.contains(element);
    }

    public void check(int index) {
        targetValue.set(index, CHECK_VALUE);
    }

    private List<Integer> mapToList(Set<Integer> set) {
        return new ArrayList<>(set);
    }

    private Set<Integer> getRandomLinkedHashSet() {
        Set<Integer> target = new LinkedHashSet<>();
        while (target.size() < GamePlayer.DIGIT_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            target.add(randomNumber);
        }
        return target;
    }
}
