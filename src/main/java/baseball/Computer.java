package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class Computer {
    private List<Integer> numbers;

    public void pickRandomNumbersFrom1To9(){
        numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public List<Integer> getComputersPick() {
        if (numbers == null){
            pickRandomNumbersFrom1To9();
        }
        return numbers;
    }
}
