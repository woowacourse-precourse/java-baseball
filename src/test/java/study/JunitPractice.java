package study;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class JunitPractice {

    public List<Integer> operate(final int money) {
        if (!isValidMoney(money)) {  //money가 천원이 아니면,
            throw new RuntimeException("올바른 금액이 아닙니다.");
        }
        return generate();
    }

    private boolean isValidMoney(final int money) {
        return money == 1000;
    }

    private List<Integer> generate() {
        return new Random()
                .ints(1, 45 + 1)
                .distinct()
                .limit(6)
                .boxed()
                .collect(Collectors.toList());
    }
}
