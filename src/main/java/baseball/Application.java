package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class Application {


    public static int escapeGame(int a) {
        OutputSentense out = new OutputSentense();

        while (!(a == 1 || a == 2)) {

            out.showMessage(out.reQuestion);
            a = out.escape(out.Question(out.restart, 1));
        }
        return a;
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //camp.nextstep.edu.missionutils.Randoms
        OutputSentense output = new OutputSentense();
        List<Integer> computer = new ArrayList<>();
        final int gameTypeNumber = 3;
        final int escapeNumberLength = 1;
        //게임 재시작시 입력 수를 1,2로 설정하 였기 때문에 예외처리시 필요한 수는 1이다.

        System.out.println(output.start);

    }
}
