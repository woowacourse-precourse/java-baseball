package util;

import baseball.util.NumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    @Test
    void 랜덤한숫자생성() {
        // given

        // when
        Integer randomNumber = NumberGenerator.getRandomNumber();

        // then
        assertThat(randomNumber).isNotNull();
    }

    @Test
    void 게임에사용할숫자리스트생성() {
        // given
        final int LIMITED = 3;

        // when
        Set<Integer> gameNumbers = new HashSet<>(NumberGenerator.createGameNumbers());

        // then
        assertThat(gameNumbers.size()).isEqualTo(LIMITED);
    }
}
