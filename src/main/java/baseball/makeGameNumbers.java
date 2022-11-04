package baseball;

import java.util.List;
import java.util.stream.Collectors;

public class makeGameNumbers {
    private List<Number> numberList;

    public makeGameNumbers(List<Integer> numberList) {
        this.numberList = numberList.stream().map(Number::new).collect(Collectors.toList());
    }

}
