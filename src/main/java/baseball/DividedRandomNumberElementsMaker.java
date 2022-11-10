package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class DividedRandomNumberElementListMaker implements ElementListMaker<Integer>{
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;

    @Override
    public List<Integer> makeElementList(int listLength) {
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

    @Override
    public List<Integer> convertToElementList(String stringNumber) {
        List<Integer> integerElementList = new ArrayList<>();

        for (int userInputIndex = 0; userInputIndex < stringNumber.length(); userInputIndex++) {
            int integerElement = Integer.parseInt(stringNumber.substring(userInputIndex, userInputIndex + 1));
            integerElementList.add(integerElement);
        }

        return integerElementList;
    }


}
