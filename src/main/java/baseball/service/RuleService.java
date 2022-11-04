package baseball.service;

import java.util.List;

public class RuleService {
    public int Strike(List<Integer> RandomNumber, List<Integer> InputNumber) {
        int cnt = 0;

        for (int idx = 0; idx < RandomNumber.size(); idx++) {
            if (RandomNumber.get(idx) == InputNumber.get(idx)) {
                cnt++;
            }
        }

        return cnt;
    }

    public int Ball(List<Integer> RandomNumber, List<Integer> InputNumber) {
        int cnt = 0;

        for (int idx = 0; idx < InputNumber.size(); idx++) {
            if (RandomNumber.contains(InputNumber.get(idx)))
                cnt++;
        }

        return cnt - Strike(RandomNumber, InputNumber);
    }

}
