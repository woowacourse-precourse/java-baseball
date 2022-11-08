package baseball;

import static baseball.Constant.MAX_INDEX;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.HashMap;
import java.util.Map;

public class Player {

    // 플레이어 기능 : 상대방(컴퓨터)의 수를 생성
    public static Map<Integer, Integer> createComputerNumber() {

        Map<Integer, Integer> computerRepository = new HashMap<>(MAX_INDEX);


        for ( int keyIndex = 0; keyIndex < MAX_INDEX; keyIndex++ ) {
            int randomNumber = pickNumberInRange(0, 9);

            if ( !computerRepository.containsValue(randomNumber) ) {
                int randomRecursion = pickNumberInRange(0, 9);
                computerRepository.put(keyIndex, randomRecursion);
            }

            if ( computerRepository.containsValue(randomNumber) ) {
                int randomRecursion = pickNumberInRange(0, 9);
                computerRepository.put(keyIndex, randomRecursion);
            }

        }

        return computerRepository;
    }



}
