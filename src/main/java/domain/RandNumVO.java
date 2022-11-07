package domain;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandNumVO {
    private final List<Integer> randNum;

    public RandNumVO(){
        this.randNum = List.of(Randoms.pickNumberInRange(0, 9)
                , Randoms.pickNumberInRange(0, 9)
                , Randoms.pickNumberInRange(0, 9));
    }

    public List<Integer> getRandNum(){
        return randNum;
    }

}
