package baseball.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static baseball.util.GameNumberGenerator.*;
import static org.assertj.core.api.Assertions.*;

public class GameNumberGeneratorTest {

    static String number;

    @BeforeAll
    static void setup() {
        number = createGameNumber();
    }

    @Test
    void 게임_숫자생성_길이_테스트() {
        assertThat(number.length()).isEqualTo(GAME_NUMBER_LENGTH);
    }

    @Test
    void 게임_숫자생성_자릿수_범위_테스트() {
        for (int i = 0; i < GAME_NUMBER_LENGTH; i++) {
            char c = number.charAt(i);
            assertThat(c).isGreaterThanOrEqualTo('1').isLessThanOrEqualTo('9');
        }
        assertThat(number.contains("0")).isFalse();
    }

    @Test
    void 게임_숫자생성_자릿수_중복_테스트() {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < GAME_NUMBER_LENGTH; i++) {
            set.add(number.charAt(i));
        }
        assertThat(set.size()).isEqualTo(GAME_NUMBER_LENGTH);
    }
}
