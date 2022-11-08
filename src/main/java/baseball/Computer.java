package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Random;
import java.util.stream.IntStream;


public class Computer {

    public int[] target = {0, 0, 0};
    int[] number_check = {0,0,0,0,0,0,0,0,0,0};

    public void makeTarget() {
        int i = 0;

        while(true) {
            if(target[2] != 0) {
                break;
            }

            int num = Randoms.pickNumberInRange(1, 9);

            if(number_check[num] == 0) {
                target[i] = num;
                number_check[num]++;
                i++;
            }
        }
    }

}