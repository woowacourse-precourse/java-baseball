package baseball;

import camp.nextstep.edu.missionutils.*;

import java.util.ArrayList;
import java.util.List;

public class RandomNumber {
    public static List<Integer> createRandomNumber() {
        List<Integer> random_number_list=new ArrayList<>();
        for (int i=0;i<3;i++){
            int random_number = Randoms.pickNumberInRange(1, 9);
            if (random_number_list.contains(random_number)){
                int sub_random = nonPermissionExistNumber(random_number);
                random_number_list.add(sub_random);
            }else {
                random_number_list.add(random_number);
            }
        }
        return random_number_list;
    }

    private static int nonPermissionExistNumber(int random_number){
        int sub_random;
        if (random_number - 1>0){
            sub_random=Randoms.pickNumberInRange(1,random_number-1);
            return sub_random;
        }else {
            sub_random=Randoms.pickNumberInRange(random_number+1,9);
            return sub_random;
        }
    }
}
