package baseball;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;

public class Result {
    public int ReOrClose(int GamerInput, List<Integer> RandomNumber) {
        int strike = 0;
        int ball;
        int want;
        while (strike != 3) {

        }
        System.out.println("맞췄습니다.");
        System.out.println("다시 하시려면 1번 종료하시려면 2번을 눌러주세요");
        want = Integer.parseInt(readLine());
        return want;
    }
}
