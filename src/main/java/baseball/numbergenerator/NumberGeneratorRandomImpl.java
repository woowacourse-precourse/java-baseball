package baseball.numbergenerator;

import baseball.NumberValidator;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGeneratorRandomImpl implements NumberGenerator{

    @Override
    public Integer generate() {
        return Randoms.pickNumberInList(getCandidateRandomNumbers());
    }

    private List<Integer> getCandidateRandomNumbers() {
        List<Integer> ret = new ArrayList<>();
        for (int number = 100; number <= 999; ++number)
            if (NumberValidator.valid(number))
                ret.add(number);
        return ret;
    }
}
