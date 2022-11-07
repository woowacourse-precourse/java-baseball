package baseball.constant;

import java.util.regex.Pattern;

public class Rules {
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 9;
    public static final int PICK_COUNT = 3;
    public static final Pattern RANGE_COUNT_PATTERN = Pattern.compile(
            String.format("[%d-%d]{%d}", START_NUMBER, END_NUMBER, PICK_COUNT));
    public static final int DEFAULT_VALUE = 0;
    public static final String MORE = "1";
    public static final String FINISH = "2";
    public static final String CORRECT_ANSWER = "스트라이크";
    public static final String SIMILAR_ANSWER = "볼 ";
    public static final String WRONG_ANSWER = "낫싱";
}
