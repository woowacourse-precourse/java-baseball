package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumbers {
    public static final int BASEBALL_NUMBERS_LENGTH = 3;
    private static final String INPUT_BASEBALL_NUMBER_DUPLICATION_EXCEPTION_MESSAGE = "중복되지 않는 숫자를 입력해주세요.";
    private static final String INPUT_BASEBALL_NUMBERS_LENGTH_EXCEPTION_MESSAGE = BASEBALL_NUMBERS_LENGTH+"자리의 숫자만 입력할 수 있습니다.";

    private final List<BaseballNumber> baseballNumberList;

    public BaseballNumbers(List<BaseballNumber> baseballNumberList){
        this.baseballNumberList = new ArrayList<>(baseballNumberList);
    }

    private void validateBaseballNumberDuplication(List<BaseballNumber> baseballNumberList){
        Set<BaseballNumber> baseballNumberSet = new HashSet<>(baseballNumberList);
        if(baseballNumberSet.size() < BASEBALL_NUMBERS_LENGTH){// 중복이 존재하는 경우
            throw new IllegalArgumentException(INPUT_BASEBALL_NUMBER_DUPLICATION_EXCEPTION_MESSAGE);
        }
    }
}
