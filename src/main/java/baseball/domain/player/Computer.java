package baseball.domain.player;


import baseball.domain.number.BaseballNumber;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private static final Integer START_INCLUSIVE = 1;
    private static final Integer END_INCLUSIVE = 9;

    private final Set<BaseballNumber> answers = new LinkedHashSet<>();

    public Computer() {
        while (answers.size() < 3) {
            Integer number = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            answers.add(new BaseballNumber(number));
        }
    }

    public List<BaseballNumber> numbers() {
        return new ArrayList<>(answers);
    }
}
