package baseball.model;

import java.util.List;

import baseball.utility.Utility;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private List<Integer> random3Digits = new ArrayList<>(3);

    public Computer(){
        setRandom3Digits();
    }

    public List<Integer> getRandom3Digits(){
        return random3Digits;
    }
    
    private void setRandom3Digits(){
        while(random3Digits.size() < Utility.DIGIT_LENGTH){
            int randmNumber = Randoms.pickNumberInRange(1,9);
            if(!random3Digits.contains(randmNumber))
            random3Digits.add(randmNumber);
        }        
    }
}