package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            List<Integer> computerNumber = makeComputerRandomNumber();

        }


    }

    public static List<Integer> makeComputerRandomNumber() {
        List<Integer> numArr = new ArrayList<Integer>();

        while (numArr.size() < 3) {
            pickRandomNumber(numArr);
        }

        return numArr;
    }

    public static List<Integer> pickRandomNumber(List<Integer> numArr) {
        int number = Randoms.pickNumberInRange(1, 9);

        if (!numArr.contains(number)) {
            numArr.add(number);
        }

        return numArr;
    }
}
