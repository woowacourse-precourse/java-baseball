package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class ComputerNumber {
    private static final int CNT_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private List<Integer> digits;

    public ComputerNumber(){

    }

    public void setRandom(){

        Set<Integer> digitSet = new HashSet<>();

        while(digitSet.size() < CNT_NUMBER){
            digitSet.add(getRandom());
        }

        digits = new ArrayList<>(digitSet);
    }

    private int getRandom(){
        return Randoms.pickNumberInRange(MIN_NUMBER,MAX_NUMBER);
    }

}
