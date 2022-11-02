package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class Result {
    public int ReOrClose(List<Integer> RandomNumber) {
        Rules rules = new Rules();
        int strike = 1;
        int ball;
        int want;

        int inputNum;

        while (strike != 3) {
            System.out.print("숫자를 입력해 주세요 : ");
            inputNum = Integer.parseInt(Console.readLine());
            List<Integer> inputNumber = returnList(inputNum);
            Collections.reverse(inputNumber);

            strike = rules.Strike(RandomNumber, inputNumber);
            ball = rules.Ball(RandomNumber, inputNumber);
            if (strike == 0 && ball == 0) {
                System.out.println("낫싱");
            } else if (strike != 0 && ball == 0) {
                System.out.println(strike + "스트라이크");
            } else if (strike == 0 && ball != 0) {
                System.out.println(ball + "볼");
            } else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("다시 하시려면 1번 종료하시려면 2번을 눌러주세요");
        want = Integer.parseInt(readLine());
        return want;
    }

    private List<Integer> returnList(int inputNum) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add(inputNum % 10);
            inputNum /= 10;
        }
        return list;
    }
}
