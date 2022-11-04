package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String answer = makeBall();
    }

    static String makeBall() {
        List<Integer> cands = new ArrayList<>();
        while(cands.size() < 3) {
            int num = Randoms.pickNumberInRange(1, 9);
            if(!cands.contains(num)) {
                cands.add(num);
            }
        }
        String balls = "";
        for(int ball : cands) {
            balls += ball;
        }
        return balls;
    }
}
