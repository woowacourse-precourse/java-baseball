package baseball;

import baseball.domain.BaseBallNumber;

import java.util.List;
import java.util.stream.Collectors;

public class makeGameNumbers {
    private List<BaseBallNumber> baseBallNumbersList;

    public makeGameNumbers(List<Integer> numberList) {
        this.baseBallNumbersList = numberList.stream().map(BaseBallNumber::new).collect(Collectors.toList());
    }

}
