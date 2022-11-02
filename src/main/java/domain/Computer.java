package domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public Numbers make() {
        List<Number> numbers = new ArrayList<>();

        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (checkDuplicate(randomNumber, numbers)) continue;

            numbers.add(new Number(randomNumber));
        }
        return new Numbers(numbers);
    }

    private boolean checkDuplicate(int randomNumber, List<Number> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i).equals(new Number(randomNumber))) return true;
        }
        return false;
    }
}
