package baseball;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    static List<Integer> computerRandomNumber = new ArrayList<>();
    public static void main(String[] args) {
        while(true){
            if (computerRandomNumber.size()==0){
                computerRandomNumber=makeRandomNumber();
            }

        }
    }
    
    static List<Integer> makeRandomNumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
