package baseball.computer;

import baseball.constant.GameProcedureConstantInteger;
import baseball.random.Random;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static List<Integer> createThreeLengthIntegerList() {
        List<Integer> threeLengthNonDuplicateIntegerList = new ArrayList<>();
        while (threeLengthNonDuplicateIntegerList.size()
                < GameProcedureConstantInteger.BASEBALL_GAME_NUMBER_LENGTH.getIntegerValue()) {
            int randomValue = Random.randomIntegerCreatorFromArgs1ToArgs2(
                    GameProcedureConstantInteger.RANDOM_INCLUSIVE_INTEGER_START.getIntegerValue(),
                    GameProcedureConstantInteger.RANDOM_INCLUSIVE_INTEGER_FINISH.getIntegerValue());
            if (!(threeLengthNonDuplicateIntegerList.contains(randomValue))) {
                threeLengthNonDuplicateIntegerList.add(randomValue);
            }
        }
        return threeLengthNonDuplicateIntegerList;
    }
}
