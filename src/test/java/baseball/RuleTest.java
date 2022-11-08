package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RuleTest extends NsTest {
    Rule rule = new Rule();
    List<Integer> computerNumbers = new ArrayList<>();
    List<Integer> userNumbers = new ArrayList<>();

    @Test
    void strikeRule() {

        computerNumbers.add(3);
        computerNumbers.add(6);
        computerNumbers.add(1);

        userNumbers.add(3);
        userNumbers.add(7);
        userNumbers.add(5);

        rule.strikeRule(computerNumbers, userNumbers);
        assertEquals(rule.strike, 1);

    }

    @Test
    void ballRule() {

        computerNumbers.add(3);
        computerNumbers.add(6);
        computerNumbers.add(1);

        userNumbers.add(5);
        userNumbers.add(3);
        userNumbers.add(7);

        rule.ballRule(computerNumbers, userNumbers);
        assertEquals(rule.ball, 1);

    }

    @Override
    protected void runMain() {

    }
}