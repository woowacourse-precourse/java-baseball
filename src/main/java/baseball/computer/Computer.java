package baseball.computer;

import baseball.random.Random;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static List<Integer> createThreeLengthIntegerList() {
        List<Integer> threeLengthNonDuplicateIntegerList = new ArrayList<>();
        while (threeLengthNonDuplicateIntegerList.size() < 3) {
            int randomValue = Random.randomIntegerCreatorFromArgs1ToArgs2(1, 9);
            if (!(threeLengthNonDuplicateIntegerList.contains(randomValue))) {
                threeLengthNonDuplicateIntegerList.add(randomValue);
            }
        }
        return threeLengthNonDuplicateIntegerList;
    }
}
