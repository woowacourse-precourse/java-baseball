package baseball.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ThreeNumber {
    private List<Integer> number;

    public ThreeNumber() {
        this.number = new ArrayList<>();
    }

    public int getNumber(int index) {
        return number.get(index);
    }

    public List<Integer> getThreeNumber() {
        return number;
    }

    public void setNumber(String input) {
        char[] inputs = input.toCharArray();

        for (char num : inputs) {
            number.add(num - '0');
        }
    }

    public void generate() {
        number = new ArrayList<>();
        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }
    }
}
