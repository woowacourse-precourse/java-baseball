package baseball;

import static baseball.Constant.MAX_INDEX;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.HashMap;
import java.util.Map;

public class Player {

    // 플레이어 기능 : 상대방(컴퓨터)의 수를 생성
    public static Map<Integer, Integer> createComputerNumber() {

        Map<Integer, Integer> computerRepository = new HashMap<>();

        for (int keyIndex = 0; keyIndex < MAX_INDEX; keyIndex++) {

            computerRepository.put(keyIndex, pickNumberInRange(1, 9));

        }

        return computerRepository;
    }

}
