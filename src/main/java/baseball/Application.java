package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static List<Integer> makenumber(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static void main(String[] args) {
        List<Integer> computer = new ArrayList<>();
        computer = makenumber();
        


        }
    }

