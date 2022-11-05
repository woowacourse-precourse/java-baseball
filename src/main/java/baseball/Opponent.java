package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Opponent {
    private List<Integer> numbers;

    public Opponent(){
        numbers = new ArrayList<Integer>();
        while(numbers.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!numbers.contains(randomNumber)){
                numbers.add(randomNumber);
            }
        }
    }
    public boolean isStrike(int key,int value){
        if(numbers.get(key)==value)
            return true;
        return false;
    }
    public boolean isBall(int key,int value){
        for(int i=0; i<3; i++){
            if(key==i) continue;
            if(numbers.get(i)==value)return true;
        }
        return false;
    }
    public int getValue(char value){
        return Character.getNumericValue(value);
    }
    public String makeHint(String input){
        String hint="";
        int strike=0;
        int ball=0;
        int value;
        for(int i=0; i<3; i++){
            value = getValue(input.charAt(i));
            if(isStrike(i,value)){
              strike++;
              continue;
            }
            if(isBall(i,value)) ball++;
        }
        hint += Integer.toString(strike)+Integer.toString(ball);
        return hint;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    public void setNumbers(List<Integer> numberArray){
       numbers.clear();
       numbers.addAll(new ArrayList<Integer>(numberArray));
    }
}
