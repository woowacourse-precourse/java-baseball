package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.Constants.*;

public class Computer {
    private List<Integer> generateRandomNumber() {
        List<Integer> randomNumberList = new ArrayList<>();
        for (int i = 0; i < MAX_NUMBER_RESULT_SIZE; i++) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (randomNumberList.contains(randomNumber)) {
                i--;
            }
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        return randomNumberList;
    }

    private String randomNumberListToString(List<Integer> randomNumberList) {
        return randomNumberList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    // 해당 함수의 역할은 3자리 서로 다른 IntegerList 를 받아서 sTring으로 바꾼다
    public String randomNumberToStringResult() {
        return randomNumberListToString(generateRandomNumber());
    }
}
