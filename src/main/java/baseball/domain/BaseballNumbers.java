package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    public static final int BASEBALL_NUMBERS_LENGTH = 3;
    private static final String INPUT_BASEBALL_NUMBER_DUPLICATION_EXCEPTION_MESSAGE = "중복되지 않는 숫자를 입력해주세요.";
    private static final String INPUT_BASEBALL_NUMBERS_LENGTH_EXCEPTION_MESSAGE = BASEBALL_NUMBERS_LENGTH+"자리의 숫자만 입력할 수 있습니다.";

    private final List<BaseballNumber> baseballNumberList;

    public BaseballNumbers(List<BaseballNumber> baseballNumberList){
        this.baseballNumberList = new ArrayList<>(baseballNumberList);
    }
}
