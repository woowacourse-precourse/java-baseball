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

        char valueZero = numberToString.charAt(0);
        char valueOne = numberToString.charAt(1);
        char valueTwo = numberToString.charAt(2);

        computerRepository.put(0, valueZero);
        computerRepository.put(1, valueOne);
        computerRepository.put(2, valueTwo);

        return computerRepository;
    }
}
