package baseball.domain;

import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    void get_add_맵에_결과를_반영() {
        Result result = new Result();

        result.add(ResultType.BALL);
        result.add(ResultType.STRIKE);
        result.add(ResultType.STRIKE);

        assert (result.get(ResultType.BALL) == 1);
        assert (result.get(ResultType.STRIKE) == 2);
        assert (result.get(ResultType.NOTHING) == 0);
    }

    @Test
    void isNothing_낫싱_판단() {
        Result result = new Result();
        assert (result.isNothing());

        result.add(ResultType.BALL);
        assert (!result.isNothing());
    }

}
