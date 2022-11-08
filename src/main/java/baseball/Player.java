package baseball;

import static baseball.Constant.MAX_INDEX;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashMap;
import java.util.Map;

public class Player {

    private static int keyIndex;

    // 플레이어 기능 : 상대방(컴퓨터)의 수를 생성
    public static Map<Integer, Integer> createComputerNumber() {

        Map<Integer, Integer> computerRepository = new HashMap<>(MAX_INDEX);

        while (computerRepository.size() < MAX_INDEX) {

            int randomNumber = Randoms.pickNumberInRange(0,9);

            if ( !computerRepository.containsValue(randomNumber) ) {
                computerRepository.put(keyIndex, randomNumber);
                keyIndex++;
            }

            if (keyIndex > MAX_INDEX) { keyIndex = 0; }
            if (randomNumber == 9) {
                int randomException = Randoms.pickNumberInRange(2, 5);
                computerRepository.put(keyIndex, randomException);
            }
        }

        return computerRepository;
    }



}
