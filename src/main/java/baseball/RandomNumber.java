package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    public List<Integer> get(){
        List<Integer> randomNumberList = new ArrayList<>();
        for (int digit = 0; digit < 3; digit++){
            randomNumberList.add(getValidateNumber(randomNumberList));
        }
        return randomNumberList;
    }

    private int getValidateNumber(List<Integer> randomNumberList){
        int newNumber = Randoms.pickNumberInRange(1, 9);
        while (randomNumberList.contains(newNumber)){
            newNumber = Randoms.pickNumberInRange(1, 9);
        }
        return newNumber;
    }
}
