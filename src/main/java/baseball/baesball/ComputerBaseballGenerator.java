package baseball.baesball;

import baseball.util.RandomUtil;

import java.util.List;

public class ComputerBaseballGenerator implements BaseballGenerator {
    @Override
    public Baseball generateBaseball() {
        String baseball = RandomUtil.randomSizeThree();
        List<Integer> parsedBaseball = parseFrom(baseball);
        return new Baseball(parsedBaseball);
    }
}
