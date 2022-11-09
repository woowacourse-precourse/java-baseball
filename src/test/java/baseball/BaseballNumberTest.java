package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseballNumberTest {
    @Test
    public void makeRandomNumber() {
        BaseballNumber baseballNumber = new BaseballNumber();
        baseballNumber.makeRandomNumber();
        List<String> createdNumber = baseballNumber.getNumber();

        Assertions.assertThat(createdNumber.size()).isEqualTo(BaseballNumber.numberLength);

        for (int i = 0; i < BaseballNumber.numberLength; i++) {
            for (int j = i + 1; j < BaseballNumber.numberLength; j++) {
                Assertions.assertThat(createdNumber.get(i)).isNotEqualTo(createdNumber.get(j));
            }
        }
    }

    @Test
    public void matchTest() {
        BaseballNumber baseballNumber = new BaseballNumber();
        baseballNumber.setNumber(new ArrayList<>(Arrays.asList("1", "2", "3")));
        MatchResult matchResult = baseballNumber.match(new ArrayList<>(Arrays.asList("1", "3", "7")));
        Assertions.assertThat(matchResult.getBall()).isEqualTo(1);
        Assertions.assertThat(matchResult.getStrike()).isEqualTo(1);
    }

}