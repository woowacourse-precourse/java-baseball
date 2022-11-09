package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Baseball {

    private List<Integer> number;

    public void setNumber() {
        List<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }

        this.number = randomNumberList;
    }

    public List<Integer> getNumber() {
        return this.number;
    }
}
