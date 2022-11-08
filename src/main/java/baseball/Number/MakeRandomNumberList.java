package baseball.Number;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class MakeRandomNumberList{
    private List<Integer> randomNumberList;

    public void makeRandomNumberList() {
        List<Integer> randomNumberList = new ArrayList<>();

        while(randomNumberList.size() < 3 ){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        this.randomNumberList = randomNumberList;
    }

    public List<Integer> getRandomNumberList() {
        return randomNumberList;
    }
}
