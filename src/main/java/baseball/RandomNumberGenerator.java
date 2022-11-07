package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {
    private String randomNumber;

    public RandomNumberGenerator(){
        setRandomNumber();
    }
    public void setRandomNumber(){
        List<String> numberList=new ArrayList<>();
        while(numberList.size()<3){
            String randomNumber= Integer.toString(Randoms.pickNumberInRange(1, 9));
            if(!numberList.contains(randomNumber)){
                numberList.add(randomNumber);
            }
        }
        this.randomNumber=String.join("", numberList);
    }
    public String getRandomNumber() {
        return randomNumber;
    }

}
