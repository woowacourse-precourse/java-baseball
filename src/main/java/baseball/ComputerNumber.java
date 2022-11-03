package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    List<Integer> computerNumber = new ArrayList<>();

    public List<Integer> GetComputerNumber(){
        while(computerNumber.size() < NumberNaming.MAX_NUMBER_SIZE){
            createRandomNumber(Randoms.pickNumberInRange(NumberNaming.MIN_RANGE_NUM,NumberNaming.MAX_RANGE_NUM));
            }
        return computerNumber;
        }

    public void createRandomNumber(int number){
        if(!computerNumber.contains(number)){
            computerNumber.add(number);
        }
    }

}
