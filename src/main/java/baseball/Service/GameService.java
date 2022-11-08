package baseball.Service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class GameService {
    /**
     * 컴퓨터가 정답을 생성하는 Method
     * @return 생성된 정답을 돌려준다
     */
    public List<Integer> ComputerAnswer() {
        List<Integer> computerAnswer = new ArrayList<>();
        while (computerAnswer.size() < 3) {
            int tmp = Randoms.pickNumberInRange(1, 9);
            if (!computerAnswer.contains(tmp)) {
                computerAnswer.add(tmp);
            }
        }
        return computerAnswer;
    }
}
