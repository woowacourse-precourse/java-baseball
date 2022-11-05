package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerBaseball {
    private List<Integer> baseballNumberList = new ArrayList<>();

    public ComputerBaseball() {
        initNumbers();
    }

    private void initNumbers() {
        while (baseballNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!baseballNumberList.contains(randomNumber)) {
                baseballNumberList.add(randomNumber);
            }
        }
    }
    public List<Integer> getBaseballNumberList() {
        return baseballNumberList;
    }

    public void resetNumeberList() {
        baseballNumberList.clear();
        initNumbers();
    }

}
