package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

class computer {
    int computerNumber(){
        ArrayList<Integer> computer = new ArrayList<>();
        while(computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        int number = computer.get(0)*100 + computer.get(1)*10 + computer.get(2);
        return number;
    }
}

public class Application {
    public static void main(String[] args) {
        
    }
}
