package baseball;

import java.util.List;

public class Core {
    public boolean isDigitStrike(List<Integer> computerNumber, List<Integer> userNumber, int index){
        return computerNumber.get(index).equals(userNumber.get(index));
    }

    public int countStrike(List<Integer> computerNumber, List<Integer> userNumber){
        int count=0;
        for(int index=0; index<userNumber.size(); index++){
            if(isDigitStrike(computerNumber,userNumber,index)){
                count++;
            }
        }
        return count;
    }
}
