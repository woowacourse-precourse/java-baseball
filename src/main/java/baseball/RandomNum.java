package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNum {


    public static List randomNum(){
        /*
        int[] randomNum = new int[3]; // 서로다른 3개 숫자
        Random rand = new Random();

        for(int count = 0; count < 3; count++){ // 랜덤 숫자 3개 뽑기
            randomNum[count] = rand.nextInt(9) + 1; // 1 ~9
            for(int curCount = 0; curCount < count; curCount++){
                if(randomNum[count] == randomNum[curCount]){ // 중복이면
                    count--; // 중복 아닌 수로 다시 찾기
                }
            }
            System.out.println("랜덤 num: " + randomNum[count]);
        }
        return randomNum;

         */
        List<Integer> randomNum;
        randomNum = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(number)) {
                randomNum.add(number);
            }
            System.out.println("랜덤 num: " + randomNum.get(i));
        }

        return randomNum;

    }

}
