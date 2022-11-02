package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class Result {
    public int ReOrClose(int GamerInput, List<Integer> RandomNumber) {
        int strike = 3;
        int ball;
        int want;
        List<Integer> inputNumber = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            inputNumber.add(GamerInput % 10);
            System.out.println(GamerInput % 10);
            GamerInput /= 10;
        }
        Collections.reverse(inputNumber);

        while (strike != 3) {

        }
        System.out.println("맞췄습니다.");
        System.out.println("다시 하시려면 1번 종료하시려면 2번을 눌러주세요");
        want = Integer.parseInt(Console.readLine());
        return 2;
    }
}
