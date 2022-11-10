package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class DividedRandomNumberElementsMaker implements ElementsMaker<Integer> {
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;

    @Override
    public List<Integer> makeElements(int listLength) {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < listLength) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

            if (!isNumberContained(randomNumber, randomNumbers)) {
                randomNumbers.add(randomNumber);
            }
        }

        return randomNumbers;
    }

    public boolean isNumberContained(int randomNumber, List<Integer> randomNumbers) {
        if (randomNumbers.contains(randomNumber)) {
            return true;
        }

        return false;
    }

    @Override
    public List<Integer> convertToElements(String number) {
        List<Integer> integerElements = new ArrayList<>();

        for (int userInputIndex = 0; userInputIndex < number.length(); userInputIndex++) {
            int integerElement = Integer.parseInt(number.substring(userInputIndex, userInputIndex + 1));
            integerElements.add(integerElement);
        }

        return integerElements;
    }


}
