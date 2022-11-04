package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        for(int i = 0; i < 1000; i++){
            System.out.println(RandomBallNum());
        }
    }

    public static List<Integer> RandomBallNum() {
        List<Integer> BallNum = new ArrayList<>(3);
        while (BallNum.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!BallNum.contains(randomNum)) {
                BallNum.add(randomNum);
            }
        }

        return BallNum;
    }
}
