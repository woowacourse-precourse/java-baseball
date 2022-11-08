package baseball.tools;

import java.util.HashSet;

public class GenerateNumber {
    StringBuilder uniqueNumber = new StringBuilder();

    public StringBuilder pickThreeUniqueRandomNumber() {
        HashSet<Integer> uniqueNumbersSet = new HashSet<>();

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
