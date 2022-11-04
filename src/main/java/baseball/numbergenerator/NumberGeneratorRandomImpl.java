package baseball.numbergenerator;

import baseball.NumberValidator;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGeneratorRandomImpl implements NumberGenerator {
    private static NumberGeneratorRandomImpl numberGeneratorRandom;

    private NumberGeneratorRandomImpl() {
    }

    public static NumberGeneratorRandomImpl getInstance() {
        if (numberGeneratorRandom == null)
            numberGeneratorRandom = new NumberGeneratorRandomImpl();
        return numberGeneratorRandom;
    }

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
