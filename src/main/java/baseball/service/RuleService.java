package baseball.service;

import java.util.List;

public class RuleService {
    public int Strike(List<Integer> RandomNumber, List<Integer> InputNumber) {
        int cnt = 0;

        for (int i = 0; i < RandomNumber.size(); i++) {
            if (RandomNumber.get(i) == InputNumber.get(i)) {
                cnt++;
            }
        }

        return cnt;
    }

    public int Ball(List<Integer> RandomNumber, List<Integer> InputNumber) {
        int cnt = 0;

        for (int in = 0; in < InputNumber.size(); in++) {
            if (RandomNumber.contains(InputNumber.get(in)))
                cnt++;
        }

        return cnt - Strike(RandomNumber, InputNumber);
    }

}
