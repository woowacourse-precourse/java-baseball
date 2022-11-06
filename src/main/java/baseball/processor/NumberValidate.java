package baseball.processor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberValidate {

    /**
     * 1-9 까지의 숫자인지 검증한다.
     * 서로 다른 숫자만 입력했는지 검증한다.
     * size 자리의 숫자인지 검증한다.
     * @param inputNumber - 유저의 입력 숫자 리스트
     * @param size - 현재게임의 숫자 사이즈
     */
    public void validation(List<Integer> inputNumber, Integer size){
        if (inputNumber.size() != size) throw new IllegalArgumentException(size+"자리 숫자만 입력 가능합니다.");

        Set<Integer> inputNumberSet = new HashSet<>(inputNumber);

        if (inputNumberSet.contains(0)) throw new IllegalArgumentException("1부터 9까지의 숫자만 입력 가능합니다.");

        if (inputNumberSet.size() != size) throw new IllegalArgumentException(size+"개의 숫자는 서로 다른 숫자만 입력 가능합니다.");
    }
}
