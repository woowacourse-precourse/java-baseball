package baseball.number;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberJudgment {
    private Map<Integer, Integer> computerSameNumberIndex = new HashMap<>();

    public int getSameNumberCount(List<Integer> computerNumberList, List<Integer> userNumberList) { // 같은 숫자가 있는가?
        int sameNumberCount = 0;

        for (int userNumber : userNumberList) {
            if (computerNumberList.contains(userNumber)) {
                computerSameNumberIndex.put(userNumber, computerNumberList.indexOf(userNumber));
                sameNumberCount++;
            }
        }
        return sameNumberCount;
    }

    public int getSameIndexCount(List<Integer> userNumberList) { // 같은 인덱스에 있는가?
        int sameIndexCount = 0;

        for(Map.Entry<Integer, Integer> numberEntry : computerSameNumberIndex.entrySet()) {
            int computerSameNumber = numberEntry.getKey();
            int computerSameIndex = numberEntry.getValue();

            if (userNumberList.indexOf(computerSameNumber) == computerSameIndex) {
                sameIndexCount++;
            }
        }

        return sameIndexCount;
    }
}