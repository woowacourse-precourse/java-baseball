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
                int sub_random = nonPermissionExistNumber(random_number_list, random_number);
                random_number_list.add(sub_random);
            }else {
                random_number_list.add(random_number);
            }
        }
        return random_number_list;
    }

    private static int nonPermissionExistNumber(List<Integer>random_number_list,int random_number){
        int sub_random;
        while (true){
            sub_random= Randoms.pickNumberInRange(1, 9);
            if (sub_random!=random_number){
                break;
            }
        }
        return sub_random;
    }
}
