package baseball.model;

import baseball.model.Constant.Score;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static baseball.model.Constant.Score.NOTHING;
import static baseball.model.Constant.Score.STRIKE;

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

    public Integer getDigit(int index){
        return digits.get(index);
    }

    private int getRandom(){
        return Randoms.pickNumberInRange(MIN_NUMBER,MAX_NUMBER);
    }

    public Score getScore(int userNumber, int index){

        for(int i=0;i<CNT_NUMBER;i++){
            Integer ComputerNum = digits.get(i);

            if(ComputerNum == userNumber && i == index){
                return STRIKE;
            }else if(ComputerNum == userNumber){
                return BAll;
            }
        }

        return NOTHING;

    }



}
