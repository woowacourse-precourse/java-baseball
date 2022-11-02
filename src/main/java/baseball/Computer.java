package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;

public class Computer {
    private List<Integer> numbers;

    public void pickRandomNumbersFrom1To9(){
        numbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

    public List<Integer> getComputersPick(){
        if (numbers == null){
            pickRandomNumbersFrom1To9();
        }
        return numbers;
    }
}
