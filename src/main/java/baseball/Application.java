package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static int makeTargetNum() {

        List<Integer> target = new ArrayList<>();

        while (target.size() < 3) {
            int n = Randoms.pickNumberInRange(1, 9);
            if (!target.contains(n)) {
                target.add(n);
            }
        }

        System.out.println("target " + target);
        String stringOfTargetNum = "";
        for (int n : target) {
            stringOfTargetNum += n;
        }

        return Integer.parseInt(stringOfTargetNum);
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int target = makeTargetNum();


    }


}
