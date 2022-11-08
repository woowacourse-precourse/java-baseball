package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.LinkedList;

public class RandomNumbersMaker {
    final int START_INCLUSIVE = 1;
    final int END_INCLUSIVE = 9;
    final int LIMIT_SIZE = 3;

    public LinkedList<Integer> makeRandomNumbers() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < LIMIT_SIZE; i++) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);

            while (set.contains(randomNumber)) {
                randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            }

            set.add(randomNumber);
            linkedList.add(randomNumber);
        }

        return linkedList;
    }
}
