package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    //컴퓨터의 랜덤 숫자 설정
    public static List<Integer> setRandomNumber() {

        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomDigit = Randoms.pickNumberInRange(1, 9);
            if (!computer.toString().contains(String.valueOf(randomDigit))) {
                computer.add(randomDigit);
            }
        }
        return computer;
    }

}
