package baseball.Domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberGeneratorTest {
    NumberGenerator numberGenerator = new NumberGenerator();

    @Test
    public void 랜덤숫자_생성_길이_테스트(){
        assertEquals(numberGenerator.make3RandomNum().size(), NumberGenerator.GAME_NUM_LENGTH);
    }

    @Test
    public void 랜덤숫자_생성_중복_테스트(){
        assertEquals(numberGenerator.make3RandomNum().stream().distinct().count(), NumberGenerator.GAME_NUM_LENGTH);
    }
}
