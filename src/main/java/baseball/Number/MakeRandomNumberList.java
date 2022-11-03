package baseball.Number;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class MakeRandomNumberList implements MakeNumberList {
    NumberListRepository numer = new NumberListRepository();

    @Override
    public void makeNumberList() {
        List<Integer> randomNumberList = new ArrayList<>();

        while(randomNumberList.size() < 3 ){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        numer.setRandomNumberList(randomNumberList);
    }
}
