package baseball.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public abstract class Utilization {
    public static List<Integer> pickRandomNumberList() {
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < Constant.NUMBER_LENGTH) {
            int randomNumber = pickNumberInRange(Constant.MIN_NUMBER_VALUE, Constant.MAX_NUMBER_VALUE);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    public static List<Integer> convertStringToIntegerList(String string) {
        return convertIntegerToIntegerList(Integer.parseInt(string));
    }

    public static List<Integer> convertIntegerToIntegerList(int integer) {
        Stream<Integer> stream = Stream
                .of(String
                        .valueOf(integer)
                        .split(""))
                .mapToInt(Integer::parseInt)
                .boxed();
        return Arrays.asList(stream.toArray(Integer[]::new));
    }
}
