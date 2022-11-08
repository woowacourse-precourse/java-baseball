package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.lang.reflect.Array;
import java.util.*;

public class Application {
    public ArrayList<Integer> make_computer_number() {
        ArrayList<Integer> com_num = new ArrayList<>();
        com_num.add(Randoms.pickNumberInRange(1, 9));
        while (com_num.size() < 3) {
            int random_num = Randoms.pickNumberInRange(1, 9);
        }
        return com_num;
    }
}
