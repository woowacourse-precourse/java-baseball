package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

import static baseball.model.SystemScoreModel.STRIKE;
import static baseball.model.SystemScoreModel.BALL;
import static baseball.model.SystemScoreModel.NOTHING;
import static baseball.model.SystemScoreModel.ZERO;


public class SystemComputerModel {
    private static final int DIGIT_COUNT = 3;
    private static final String EXIT_CODE = "2";

    private List<Integer> digits;


    public SystemComputerModel() {
    }

    public void setRandomNumber() {
        List<Integer> digitSet = new ArrayList<>();
        while(digitSet.size()<DIGIT_COUNT){
            int randomNumber=Randoms.pickNumberInRange(1, 9);
            if(!digitSet.contains(randomNumber)){
                digitSet.add(randomNumber);
            }
        }
        digits=new ArrayList<>(digitSet);
    }
}
