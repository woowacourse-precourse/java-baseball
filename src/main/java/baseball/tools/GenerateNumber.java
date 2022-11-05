package baseball.tools;

import java.util.HashSet;

public class GenerateNumber {

    public StringBuilder pickThreeUniqueRandomNumber() {
        HashSet<Integer> uniqueNumbersSet = new HashSet<>();
        StringBuilder uniqueNumber = new StringBuilder();

        while (uniqueNumbersSet.size() < 3) {
            int newNum = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1, 9);
            if (uniqueNumbersSet.contains(newNum))
                continue;
            uniqueNumbersSet.add(newNum);
        }
        for (int num : uniqueNumbersSet)
            uniqueNumber.append(num);
        return uniqueNumber;
    }
}
