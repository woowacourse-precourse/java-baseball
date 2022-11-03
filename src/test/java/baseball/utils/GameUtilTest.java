package baseball.utils;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Game Util 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class GameUtilTest {
    @DisplayName("숫자 비교")
    @Nested
    class number_compare {
        @ParameterizedTest(name = "낫싱 => {0}, {1}")
        @CsvSource({
                "123, 987", //xyz, abc
        })
        void nothing(int computer, int player) {
            List<Integer> result = GameUtil.compareNumber(computer, player);
            assertThat(result).containsOnly(0, 0);
        }

        @ParameterizedTest(name = "1스트라이크 => {0}, {1}")
        @CsvSource({
                "123, 198", //xyz, xab
                "123, 928", //xyz, ayb
                "123, 983", //xyz, abz
        })
        void one_strikes(int computer, int player) {
            List<Integer> result = GameUtil.compareNumber(computer, player);
            assertThat(result).containsOnly(0, 1);
        }

        @ParameterizedTest(name = "2스트라이크 => {0}, {1}")
        @CsvSource({
                "123, 129", //xyz, xya
                "123, 193", //xyz, xaz
                "123, 923", //xyz, ayz
        })
        void two_strikes(int computer, int player) {
            List<Integer> result = GameUtil.compareNumber(computer, player);
            assertThat(result).containsOnly(0, 2);
        }

        @ParameterizedTest(name = "3스트라이크 => {0}, {1}")
        @CsvSource({
                "123, 123", //xyz, xyz
        })
        void three_strikes(int computer, int player) {
            List<Integer> result = GameUtil.compareNumber(computer, player);
            assertThat(result).containsOnly(0, 3);
        }

        @ParameterizedTest(name = "1볼 => {0}, {1}")
        @CsvSource({
                "123, 918", //xyz, axb
                "123, 981", //xyz, abx
                "123, 298", //xyz, yab
                "123, 982", //xyz, aby
                "123, 398", //xyz, zab
                "123, 938", //xyz, azb
        })
        void one_ball(int computer, int player) {
            List<Integer> result = GameUtil.compareNumber(computer, player);
            assertThat(result).containsOnly(1, 0);
        }

        @ParameterizedTest(name = "2볼 => {0}, {1}")
        @CsvSource({
                "123, 912", //xyz, axy
                "123, 219", //xyz, yxa
                "123, 291", //xyz, yax
                "123, 319", //xyz, zxa
                "123, 391", //xyz, zax
                "123, 931", //xyz, azx
                "123, 239", //xyz, yza
                "123, 392", //xyz, zay
                "123, 932", //xyz, azy
        })
        void two_balls(int computer, int player) {
            List<Integer> result = GameUtil.compareNumber(computer, player);
            assertThat(result).containsOnly(2, 0);
        }

        @ParameterizedTest(name = "1볼 1스트라이크 => {0}, {1}")
        @CsvSource({
                "123, 192", //xyz, xay
                "123, 139", //xyz, xza
                "123, 921", //xyz, ayx
                "123, 329", //xyz, zya
                "123, 913", //xyz, axz
                "123, 293", //xyz, yaz
        })
        void one_ball_one_strike(int computer, int player) {
            List<Integer> result = GameUtil.compareNumber(computer, player);
            assertThat(result).containsOnly(1, 1);
        }

        @ParameterizedTest(name = "2볼 1스트라이크 => {0}, {1}")
        @CsvSource({
                "123, 192", //xyz, xzy
                "123, 921", //xyz, zyx
                "123, 219", //xyz, yxz
                "123, 291", //xyz, yzx
        })
        void one_strike(int computer, int player) {
            List<Integer> result = GameUtil.compareNumber(computer, player);
            assertThat(result).containsOnly(2, 1);
        }
    }
}
