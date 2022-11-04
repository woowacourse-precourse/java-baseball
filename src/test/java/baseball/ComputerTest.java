package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComputerTest {

    Computer testComputer = new Computer();

    @Test
    public void 생성한_랜덤숫자가_세자리인지() {
        // given
        List<Integer> randomDigits = testComputer.createRandomDigits();
        // when

        // then
        Assertions.assertThat(randomDigits.size()).isEqualTo(3);
    }

    @Test
    public void 생성한_랜덤숫자의_세개_모두_다른_숫자인지() {
        // given
        List<Integer> randomDigits = testComputer.createRandomDigits();
        Set<Integer> randomDigitsSet = new HashSet<>();
        // when
        for (int digit : randomDigits) {
            randomDigitsSet.add(digit);
        }
        // then
        Assertions.assertThat(randomDigitsSet.size()).isEqualTo(3);
    }

    @Test
    public void 유저와_컴퓨터의_값을_비교하여_결과_확인_3스트라이크() {
        // given
        List<Integer> userDigits = List.of(1, 2, 3);
        List<Integer> computerDigits = List.of(1, 2, 3);
        // when
        String result = testComputer.checkDigits(userDigits, computerDigits);
        // then
        Assertions.assertThat(result).isEqualTo("3스트라이크");
    }

    @Test
    public void 유저와_컴퓨터의_값을_비교하여_결과_확인_2스트라이크() {
        // given
        List<Integer> userDigits = List.of(1, 2, 4);
        List<Integer> computerDigits = List.of(1, 2, 3);
        // when
        String result = testComputer.checkDigits(userDigits, computerDigits);
        // then
        Assertions.assertThat(result).isEqualTo("2스트라이크");
    }

    @Test
    public void 유저와_컴퓨터의_값을_비교하여_결과_확인_1스트라이크() {
        // given
        List<Integer> userDigits = List.of(1, 4, 5);
        List<Integer> computerDigits = List.of(1, 2, 3);
        // when
        String result = testComputer.checkDigits(userDigits, computerDigits);
        // then
        Assertions.assertThat(result).isEqualTo("1스트라이크");
    }
}
