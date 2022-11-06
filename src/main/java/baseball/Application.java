package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(generateNumbers());
        System.out.println(inputNumberOfUser());
//        if (inputNumberOfUser() == generateNumbers()) {
//            System.out.println("right");
//        } else {
//        }
//        System.out.println("wrong");
    }

    public static List generateNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public static List inputNumberOfUser() {
        String input = Console.readLine();
        int inputNumber = Integer.parseInt(input);
            if((int)(Math.log10(inputNumber)+1) == 3) {
                System.out.println("숫자를 입력해주세요: " + input);
                return Collections.singletonList(input);
            } else
                throw new IllegalArgumentException("잘못된 입력값입니다.");
    }
}

//    public static String checkNumbers() {
//
//    }