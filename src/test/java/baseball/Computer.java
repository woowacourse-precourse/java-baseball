package baseball;

import java.util.HashSet;
import java.util.List;

public class Computer {
    Integer first;
    Integer second;
    Integer third;
    
    public void putAnswer(List<Integer> numbers) {
        if(!(numbers.size() == 3)) {
            throw new IllegalArgumentException("입력값의 크기는 3개여야 합니다");
        }
        HashSet<Integer> resultDuplicateRemoved = new HashSet<>(numbers);
        if(!(resultDuplicateRemoved.size() == 3)) {
            throw new IllegalArgumentException("값이 중복되서는 안됩니다");
        }
        Integer resultRangeValidated = (int) numbers.stream().filter(number -> 1 <= number && number <= 9).count();
        if (resultRangeValidated != 3) {
            throw new IllegalArgumentException("1이상 9이하의 숫자만 들어갈 수 있습니다");
        }
        first = numbers.get(0);
        second = numbers.get(1);
        third = numbers.get(2);
    }


    public List<Integer> returnResult(List<Integer> integers) {
        return null;
    }
}
