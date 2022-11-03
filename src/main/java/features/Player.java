package features;

import static java.lang.String.valueOf;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {

    // 플레이어 기능 : 상대방(컴퓨터)의 수를 생성
    public static Map<Integer, Character> createComputerNumber() {

        Map<Integer, Character> computerRepository = new HashMap<>();

        int playerNumber = Randoms.pickNumberInRange(1, 9);
        String numberToString = valueOf(playerNumber);

        char indexZero = numberToString.charAt(0);
        char indexOne = numberToString.charAt(1);
        char indexTwo = numberToString.charAt(2);

        computerRepository.put(0, indexZero);
        computerRepository.put(1, indexOne);
        computerRepository.put(12, indexTwo);

        return computerRepository;
    }
}
