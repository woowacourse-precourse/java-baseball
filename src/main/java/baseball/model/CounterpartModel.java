package baseball.model;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class CounterpartModel {
    private ArrayList<Integer> resultArray;

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

    public ArrayList<Integer> getResultNum() {
        return resultArray;
    }
}
