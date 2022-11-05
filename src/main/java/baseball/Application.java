package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> computer = makeRandomBall();
    }

    public static List<Integer> makeRandomBall(){
        return Randoms.pickUniqueNumbersInRange(1,9,3);
    }
}
