package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computer = new ArrayList<>();
        while (computer.size() != 3) {
            int random = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(random)) {
                computer.add(random);
            }
        }
    }
}
