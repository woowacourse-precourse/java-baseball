package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class DividedRandomNumberListMaker implements NumberListMaker{
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;

    @Override
    public List<Integer> makeNumberList(int listLength) {
        List<Integer> randomNumberList = new ArrayList<>();

        while (randomNumberList.size() < listLength) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

            if (isNumberStrangerOnNumberList(randomNumber, randomNumberList)) {
                randomNumberList.add(randomNumber);
            }
        }

        return randomNumberList;
    }

    public boolean isNumberStrangerOnNumberList(int randomNumber, List<Integer> randomNumberList) {
        if (randomNumberList.contains(randomNumber)) {
            return false;
        }

        return true;
    }
}
