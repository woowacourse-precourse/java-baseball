package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public String makeRandomNumberString() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < Game.NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return convertIntegerListToString(randomNumbers);
    }

    private String convertIntegerListToString(List<Integer> numberList) {
        StringBuilder stringBuilder = new StringBuilder();
        numberList.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
}
