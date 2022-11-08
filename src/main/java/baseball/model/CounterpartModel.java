package baseball.model;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class CounterpartModel {
    private List<Integer> resultNumList;

    public CounterpartModel() {
        GenerateRandomNum();
    }

    public void GenerateRandomNum() {
        resultNumList = new ArrayList<>();
        while(resultNumList.size() != 3) {
            int num = pickNumberInRange(1, 9);
            if(!resultNumList.contains(num)) {
                resultNumList.add(num);
            }
        }
    }

    public List<Integer> getResultNumList() {
        return resultNumList;
    }
}
