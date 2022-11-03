package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(CreateThreeNumsOfComputer());
    }

    public static List<Integer> CreateThreeNumsOfComputer() {
        List<Integer> numsOfComputer = new ArrayList<>();

        while(numsOfComputer.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if(numsOfComputer.contains(randomNum) == false) {
                numsOfComputer.add(randomNum);
            }
        }
        return numsOfComputer;
    }
}
