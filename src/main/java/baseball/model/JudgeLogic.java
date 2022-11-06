package baseball.model;

import java.util.List;
import java.util.Objects;

public class JudgeLogic {
    public int countSameNumber(List<Integer> computer, List<Integer> player) {
        int totalSameCount = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.contains(player.get(i))) {
                totalSameCount++;
            }
        }
        return totalSameCount;
    }
