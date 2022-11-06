package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumCreator {
    String create(int size) {
        List<Integer> computer = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        String createdNumber;

        while (computer.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        for (Integer i : computer) {
            stringBuilder.append(i);
        }
        createdNumber = stringBuilder.toString();

        return createdNumber;
    }
}
