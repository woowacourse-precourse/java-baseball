package baseball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Random;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static int createRandomNum(){

        int randomNum =0;
        for (int i = 0; i < 3; i++) {
            randomNum= randomNum*10+Randoms.pickNumberInRange(1,9);
        }
        return randomNum;

    }
}
