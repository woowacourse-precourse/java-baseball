package baseball;


import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        List<Integer> computer_num = Randoms.pickUniqueNumbersInRange(1,9,3);

        System.out.println("computer_num = " + computer_num);

    }


    //해당 메서드가 이미 Randoms 클래스 안에 구현되어져 있었음.
//    public static List<Integer> getRandomNumber() {
//
//        List<Integer> num = new ArrayList<>();
//
//        while (num.size() < 3) {
//            int randomNumber = Randoms.pickNumberInRange(1,9);
//            if (!num.contains(randomNumber)) {
//                num.add(randomNumber);
//            }
//        }
//
//        return num;
//
//    }
}
