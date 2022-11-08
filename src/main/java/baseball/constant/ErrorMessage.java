package baseball.constant;

import static baseball.constant.Rules.END_INCLUSIVE;
import static baseball.constant.Rules.NUMBER_LENGTH;
import static baseball.constant.Rules.START_INCLUSIVE;

public class ErrorMessage {

    public static final String INVALID_FINAL_CODE = "1 혹은 2를 입력해야합니다.";
    public static final String WRONG_LENGTH = "입력값의 길이는 " + NUMBER_LENGTH + "이어야합니다.";
    public static final String WRONG_RANGE =
            "입력값은 " + START_INCLUSIVE + "부터 " + END_INCLUSIVE + "로 이루어져야합니다.";
    public static final String NOT_DISTINCT = "입력값은 서로 다른 수로 이루어져야합니다.";
}
