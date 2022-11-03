package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class BaseballNumber {
    ArrayList<Integer> numbers = new ArrayList<>();

    public void setNumbersByRandom(){
        numbers.clear();
        while(numbers.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!numbers.contains(randomNumber)){
                numbers.add(randomNumber);
            }
        }
    }

}
