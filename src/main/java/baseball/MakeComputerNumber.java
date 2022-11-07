package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class MakeComputerNumber {
    private  MakeComputerNumber(){
    }
    public static List<String> make_computer_number(){
        List<String> computer = new ArrayList<>();
        while(computer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1,9);
            String str = String.valueOf(randomNumber);
            if(!computer.contains(str)){
                computer.add(str);
            }
        }
        return computer;
    }
}
