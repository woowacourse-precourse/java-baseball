package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    BaseBallNumber number;

    public void makeRandomNumber() {
        while (true){
            List<Integer> numberList=new ArrayList<>();
            for(int i=0;i<3;i++){
                numberList.add(Randoms.pickNumberInRange(1,9));
            }
            number=new BaseBallNumber(numberList);
            if(isValidNumber(number)){
                return;
            }
        }
    }

    private boolean isValidNumber(BaseBallNumber number) {
        if(number.hasSameNumber()) return false;
        return true;
    }

    public boolean isSameNumber(List<Integer> integerList) {
        List<Integer> number = this.number.getNumber();
        return number.equals(integerList);
    }
}
