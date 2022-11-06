package baseball;

import java.util.ArrayList;
import java.util.List;

public class ConstantAndMessage {
    public static final int NUMBER_LENGTH = 3;
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 9;
    public static final List<Integer> ALLOWED_INPUT_NUMBERS = allowedNumbers();
    private static List<Integer> allowedNumbers(){
        List<Integer> numbers = new ArrayList<>();
        for(int i=START_NUMBER;i<=END_NUMBER;i++){
            numbers.add(i);
        }
        return numbers;
    }
}
