package baseball;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberValidate {

    /**
     * 1-9 까지의 숫자인지 검증한다.
     * 3개의 다른 숫자만 입력했는지 검증한다.
     * 3자리의 숫자인지 검증한다.
     * @param inputNumber
     */
    void validation(int inputNumber){
        if (inputNumber > 999 || inputNumber < 99) throw new IllegalArgumentException("3자리 숫자만 입력 가능합니다.");

        Set<String> inputNumberSet = Stream.of(String.valueOf(inputNumber).split("")).collect(Collectors.toSet());

        if (inputNumberSet.contains("0")) throw new IllegalArgumentException("1부터 9까지의 숫자만 입력 가능합니다.");

        if (inputNumberSet.size() != 3) throw new IllegalArgumentException("3개의 숫자는 서로 다른 숫자만 입력 가능합니다.");
    }
}
