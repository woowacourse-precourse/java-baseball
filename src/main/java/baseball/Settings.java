package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Settings {
    public static List<Integer> makeNumber(){
        List<Integer> computer = new ArrayList<>();

        while(computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
