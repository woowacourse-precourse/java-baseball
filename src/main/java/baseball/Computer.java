package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 9;

    public static int getPickNumber(){
        return Randoms.pickNumberInRange(START_NUMBER,END_NUMBER);
    }

    public static List<Integer> createGameNumber(){
        Set<Integer> threeNumbers = new LinkedHashSet<>();
        while(threeNumbers.size() < 3){
            int PickNumber = getPickNumber();
            threeNumbers.add(PickNumber);
        }
        return new ArrayList<>(threeNumbers);
    }
}
