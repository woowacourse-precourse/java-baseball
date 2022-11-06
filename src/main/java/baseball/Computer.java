package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    BaseBallNumber number;

    public void makeRandomNumber() {
        while (true){
            try {
                List<Integer> numberList = randomNumberGenerate();
                number= BaseBallNumber.of(numberList);
                return;
            }catch (IllegalArgumentException e){
            }
        }
    }

    private List<Integer> randomNumberGenerate() {
        List<Integer> numberList=new ArrayList<>();
        for(int i=0;i<3;i++){
            numberList.add(Randoms.pickNumberInRange(1,9));
        }
        return numberList;
    }


    public boolean isSameNumber(List<Integer> integerList) {
        List<Integer> number = this.number.getNumber();
        return number.equals(integerList);
    }
}
