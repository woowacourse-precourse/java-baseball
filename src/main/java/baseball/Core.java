package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

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

    public List<Integer> generateComputerRandomNumber(){
        List<Integer> computerRandomNumber = new ArrayList<>();
        while (computerRandomNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerRandomNumber.contains(randomNumber)) {
                computerRandomNumber.add(randomNumber);
            }
        }
        return computerRandomNumber;
    }

    public boolean isDigitBall(List<Integer> computerNumber,List<Integer> userNumber, int index){
        if(isDigitStrike(computerNumber, userNumber, index)){
            return false;
        }
        for(int cur=0; cur<computerNumber.size(); cur++){
            if(index==cur){
                continue;
            }
            if(userNumber.get(index)==computerNumber.get(cur)){
                return true;
            }
        }
        return false;
    }

    public int countBall(List<Integer> computerNumber,List<Integer> userNumber){
        int count=0;
        for(int index=0; index<userNumber.size(); index++){
            if(isDigitBall(computerNumber, userNumber, index)){
                count++;
            }
        }
        return count;
    }
}
