package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    public List<Integer> generateRandomNumbers(){
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    public String generateCountResult(List<Integer> randomNumbers, List<Integer> userNumbers){
        Calculator calculator = new Calculator(randomNumbers, userNumbers);
        return calculator.calculate();
    }
}
