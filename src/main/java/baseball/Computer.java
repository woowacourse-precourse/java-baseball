package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    List<Integer> integerList;

    public void reComputerNumber(){
        List<Integer> integerList = new ArrayList<>();
        while(integerList.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!integerList.contains(randomNumber)){
                integerList.add(randomNumber);
            }
        }
        this.integerList = integerList;
    }

}
