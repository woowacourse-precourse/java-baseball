package baseball.model;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class CounterpartModel {
    private List<Integer> resultArray;

    public CounterpartModel() {
        GenerateRandomNum();
    }

    public void GenerateRandomNum() {
        resultArray = new ArrayList<>();
        while(resultArray.size() != 3) {
            int num = pickNumberInRange(1, 9);
            if(!resultArray.contains(num)) {
                resultArray.add(num);
            }
        }
    }

    public List<Integer> getResultList() {
        return resultArray;
    }
}
