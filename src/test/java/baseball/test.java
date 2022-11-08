package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class test {
    Baseballgame testComputer = new Baseballgame();

    @Test
    public void 생성한_랜덤숫자가_세자리인지(){
        // given
        List<Integer> randomDigits = testComputer.createRandomDigits();
        // when

        // then
        Assertions.assertThat(randomDigits.size()).isEqualTo(3);
    }
}
