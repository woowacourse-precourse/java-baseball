package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    public static List<Integer> createRandomNumber() {
        List<Integer> random_number_list=new ArrayList<>();
        for (int i=0;i<3;i++){
            random_number_list.add(Randoms.pickNumberInRange(1, 9));
        }
        return random_number_list;
    }
}
