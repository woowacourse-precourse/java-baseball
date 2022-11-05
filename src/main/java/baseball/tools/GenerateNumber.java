package baseball.tools;

import java.util.HashSet;

public class GenerateNumber {

    public HashSet<Integer> pickThreeUniqueRandomNumber() {
        HashSet<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < 3) {
            int newNum = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1, 9);
            if (uniqueNumbers.contains(newNum))
                continue;
            uniqueNumbers.add(newNum);
        }
        return uniqueNumbers;
    }
}
