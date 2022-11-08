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
            com_num = duplicate_inpection(com_num, random_num);
        }
        return com_num;
    }
    public ArrayList<Integer> duplicate_inpection(ArrayList<Integer> com_num, int random_num){
        if (!com_num.contains(random_num)) {
            com_num.add(random_num);
        }
        return com_num;
    }
}
