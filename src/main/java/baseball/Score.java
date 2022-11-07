package baseball;

import java.util.List;

public class Score {
    private String checkNumber(List<Integer> userNumbers, List<Integer> computerNumbers) {
        for (int index = 0; index < 3; index++) {
            if (userNumbers.get(index) == computerNumbers.get(index)) {
                return "스트라이크";
            }
            if (computerNumbers.contains(userNumbers.get(index))) {
                return "볼";
            }
        }
        return "낫싱";
    }
}
