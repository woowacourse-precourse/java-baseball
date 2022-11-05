package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberServiceImpl implements NumberService {
    public static final int NUM_MATCHES = 3;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    private List<Integer> computerNumbers;

    @Override
    public void pickNumbersByComputer() {
        computerNumbers = IntStream.generate(() -> Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE))
                .distinct()
                .limit(NUM_MATCHES)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public void enterNumbersByUser() {

    }

    @Override
    public void evaluateNumbers() {

    }
}
