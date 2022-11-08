package baseball;

import static baseball.Constant.MAX_INDEX;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class Player {

    private static int keyIndex;

    // 플레이어 기능 : 상대방(컴퓨터)의 수를 생성
    public static Map<Integer, Integer> createComputerNumber() {

        keyIndex++;
        Map<Integer, Integer> computerRepository = new HashMap<>(MAX_INDEX);

        while (computerRepository.size() < MAX_INDEX) {

            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computerRepository.containsValue(randomNumber)){
                computerRepository.put(keyIndex, randomNumber);
            }
        }
        if (keyIndex < MAX_INDEX ) { keyIndex = 0; }

        return  computerRepository;
    }



}
