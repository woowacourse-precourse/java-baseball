package domain;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandNumVO {
    private final List<Integer> randNum;

    public RandNumVO() throws IllegalArgumentException{
        randNum = new ArrayList<>();
        while (randNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randNum.contains(randomNumber)) {
                randNum.add(randomNumber);
            }
        }
    }

    public List<Integer> getRandNum(){
        return randNum;
    }

}
