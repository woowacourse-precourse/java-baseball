package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static void main(String[] args) {

        List<Integer> computer = new ArrayList<>();
        getComputerNumber(computer);


    }

    static void getComputerNumber(List<Integer> computer) {
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }
}
