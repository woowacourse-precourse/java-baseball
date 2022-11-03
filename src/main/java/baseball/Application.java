package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer> computer_num = getRandomNumber();



    }


    public static List<Integer> getRandomNumber() {

        List<Integer> num = new ArrayList<>();

        while (num.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!num.contains(randomNumber)) {
                num.add(randomNumber);
            }
        }

        return num;


    }
}
