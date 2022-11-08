package baseball.logic;

import baseball.domain.Result;
import baseball.domain.ResultType;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class JugdeTest {

    @Test
    void compare_볼과_스트라이크가_모두_없는_경우() {
        Judge judge = Judge.getInstance();

        Map<Integer, Integer> computerNumber = new HashMap<>();
        computerNumber.put(1, 0);
        computerNumber.put(2, 1);
        computerNumber.put(3, 2);

        Map<Integer, Integer> userNumber = new HashMap<>();
        userNumber.put(4, 0);
        userNumber.put(5, 1);
        userNumber.put(6, 2);

        Result result = judge.compare(computerNumber, userNumber);
        assert ((result.get(ResultType.BALL) == 0) && (result.get(ResultType.STRIKE) == 0));
    }

    @Test
    void compare_스트라이크만_있는_경우() {
        Judge judge = Judge.getInstance();

        Map<Integer, Integer> computerNumber = new HashMap<>();
        computerNumber.put(1, 0);
        computerNumber.put(2, 1);
        computerNumber.put(3, 2);

        Map<Integer, Integer> userNumber = new HashMap<>();
        userNumber.put(1, 0);
        userNumber.put(2, 1);
        userNumber.put(6, 2);

        Result result = judge.compare(computerNumber, userNumber);
        assert ((result.get(ResultType.BALL) == 0) && (result.get(ResultType.STRIKE) == 2));
    }

    @Test
    void compare_볼이_있는_경우() {
        Judge judge = Judge.getInstance();

        Map<Integer, Integer> computerNumber = new HashMap<>();
        computerNumber.put(1, 0);
        computerNumber.put(2, 1);
        computerNumber.put(3, 2);

        Map<Integer, Integer> userNumber = new HashMap<>();
        userNumber.put(1, 0);
        userNumber.put(3, 1);
        userNumber.put(2, 2);

        Result result = judge.compare(computerNumber, userNumber);
        assert ((result.get(ResultType.BALL) == 2) && (result.get(ResultType.STRIKE) == 1));
    }

}
