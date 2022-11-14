package baseball.core;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Initialization {

    // 정답 숫자 생성 (서로 다른 3개의 숫자)
    public static String createTargetNumber() {
        List<Integer> listOfDigits = new ArrayList<>();
        String targetNumber;
        while (listOfDigits.size() != 3) {
            int digit = Randoms.pickNumberInRange(1, 9);
            if (!listOfDigits.contains(digit)) listOfDigits.add(digit);
        }
        targetNumber = listOfDigits.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        return targetNumber;
    }
}
