package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    private static List<Integer> rand_num_gen() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        return computer;
    }

    public static void main(String[] args) {

        //1. 상대방이 랜덤한 세 자리수를 생성한다.
        List<Integer> rand_num = rand_num_gen();
    }
}
