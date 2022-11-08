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

    @Test
    void isCorrect_비어있는_경우_오답_판단() {
        Result result = new Result();
        assert (!result.isCorrect(3));
    }

    @Test
    void isCorrect_볼만_경우_오답_판단() {
        Result result = new Result();
        result.add(ResultType.BALL);
        result.add(ResultType.BALL);
        assert (!result.isCorrect(3));
    }

    @Test
    void isCorrect_스트라이크가_부족한_경우_오답_판단() {
        Result result = new Result();
        result.add(ResultType.STRIKE);
        result.add(ResultType.STRIKE);
        assert (!result.isCorrect(3));
    }

    @Test
    void isCorrect_모두_스트라이크인_경우_정답_판단() {
        Result result = new Result();
        result.add(ResultType.STRIKE);
        result.add(ResultType.STRIKE);
        result.add(ResultType.STRIKE);
        assert (result.isCorrect(3));
    }

}
