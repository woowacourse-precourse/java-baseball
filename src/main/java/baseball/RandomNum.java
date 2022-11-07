package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNum {


    public static List randomNum(){

        List<Integer> randomNum;
        randomNum = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(number)) {
                randomNum.add(number);
            }
            System.out.println("랜덤 num: " + randomNum.get(i));
        }
        System.out.println("랜덤 num: " + randomNum);

        return randomNum;

    }

}
