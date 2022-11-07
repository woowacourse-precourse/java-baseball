package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static boolean createComputerNum(List<Integer> computer){
        while(computer.size() < 3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        if(computer.size() == 3)
            return true;
        else
            return false;
    }
}
