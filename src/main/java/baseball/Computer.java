package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import util.ComInput;
import util.Constants;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> numbers;

    private void setNumbers() {

        numbers = new ArrayList<>();
        while (numbers.size() < Constants.NUMBER_LENGTH){
            int randomNumber = Randoms.pickNumberInRange(Constants.MIN_NUMBER, Constants.MAX_NUMBER);
            if (!numbers.contains(randomNumber)){
                numbers.add(randomNumber);
            }
        }
    }

    public List<Integer> getNumbers(){

        do {
            setNumbers();
        }while (!ComInput.isValidComInput(numbers));

        return numbers;
    }
}
