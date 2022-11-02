package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class Result {
    public int ReOrClose(List<Integer> RandomNumber) {
        int strike = 1;
        int ball;
        int want;

        int inputNum;

        while (strike != 3) {
            System.out.print("숫자를 입력해 주세요 : ");
            inputNum = Integer.parseInt(Console.readLine());
        }
        System.out.println("맞췄습니다.");
        System.out.println("다시 하시려면 1번 종료하시려면 2번을 눌러주세요");
        want = Integer.parseInt(readLine());
        return want;
    }
}
