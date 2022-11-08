package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static List<Integer> numberList;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("숫자 아규 게임을 시작합니다.");

        baseball();
    }

    private static void baseball() {
        String answer = createRandomNumber();


    }


    private static String createRandomNumber() {
        StringBuilder randomNum = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            int random = Randoms.pickNumberInRange(1, 9);

            while (randomNum.toString().contains(Integer.toString(random))) {
                random = Randoms.pickNumberInRange(1, 9);
            }
            randomNum.append(random);
        }
        return randomNum.toString();
    }


}
