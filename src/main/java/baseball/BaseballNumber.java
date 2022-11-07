package baseball;
import camp.nextstep.edu.missionutils.*;
public class BaseballNumber {

    private String number;


    public void BaseballNumber() {
        this.number = "";
        for(int i = 0; i < 3; i++){
            this.number += Integer.toString(Randoms.pickNumberInRange(1,9));
        }
    }

}

