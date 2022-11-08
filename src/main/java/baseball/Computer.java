package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int NUMBER_LENGTH = 3;
    private List<Integer> targetNumList = new ArrayList<>();

    public Computer() {
        TargetNumberGenerator();
    }

    public void TargetNumberGenerator() {
        Set<Integer> targetSet = new HashSet<>();

        while (targetSet.size() < NUMBER_LENGTH) {
            targetSet.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        }
        this.targetNumList = SetToList(targetSet);
    }

    public List<Integer> SetToList(Set<Integer> target) {
        return new ArrayList<>(target);
    }

    public List<Integer> getTargetNumber() {
        return targetNumList;
    }
}
