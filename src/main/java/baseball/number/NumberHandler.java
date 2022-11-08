package baseball.number;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberHandler {

    public static List<Integer> createRandomNumberList() {
        List<Integer> randomNumberList = new ArrayList<>();

        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        return randomNumberList;
    }

    public static List<Integer> splitNumber(int numbers) { // 123 -> [1, 2, 3]
        return Stream
                .of(String.valueOf(numbers).split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
