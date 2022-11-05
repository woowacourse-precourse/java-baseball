package baseball;

import java.util.List;

public class CountBallAndStrike {
    private int ball;
    private int strike;

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }


    private int countStrike(List<Character> baseballNumber, String number){
        int count = 0;
        for(int unitNum=0; unitNum<baseballNumber.size(); unitNum++){
            if(baseballNumber.get(unitNum).equals(number.charAt(unitNum))){
                count++;
            }
        }
        return count;
    }
}
