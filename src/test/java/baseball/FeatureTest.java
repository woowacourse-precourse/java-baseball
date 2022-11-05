package baseball;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class FeatureTest {

    @Nested
    class getPlayResultTest {
        @Test
        void case1() {
            List<Integer> userNumber = List.of(1, 4, 7);
            List<Integer> Answer = List.of(1, 4, 7);
            boolean result = false;
            GameService gameService = new GameService();
            assertThat(gameService.getPlayResult(userNumber, Answer)).isEqualTo(result);
        }

        @Test
        void case2() {
            List<Integer> userNumber = List.of(5, 8, 2);
            List<Integer> Answer = List.of(1, 4, 7);
            boolean result = true;
            GameService gameService = new GameService();
            assertThat(gameService.getPlayResult(userNumber, Answer)).isEqualTo(result);
        }

        @Test
        void case3() {
            List<Integer> userNumber = List.of(4, 1, 7);
            List<Integer> Answer = List.of(1, 4, 7);
            boolean result = true;
            GameService gameService = new GameService();
            assertThat(gameService.getPlayResult(userNumber, Answer)).isEqualTo(result);
        }
    }

    @Nested
    class ExceptionTest {
        @Test
        void exception_유저의_입력_값이_3자리가_아닌_경우() {
            String input = "1234";

            assertThatThrownBy(() -> InputException.checkInputNumberValidation(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void exception_유저의_입력_값이_정수가_아닌_경우() {
            String input = "12a";

            assertThatThrownBy(() -> InputException.checkInputNumberValidation(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void exception_유저의_입력_값에_0이_들어간_경우() {
            String input = "012";

            assertThatThrownBy(() -> InputException.checkInputNumberValidation(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void exception_유저의_입력_값이_중복인_경우() {
            String input = "112";

            assertThatThrownBy(() -> InputException.checkInputNumberValidation(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void exception_재시작_혹은_종료_선택시_1과_2가_아닌_수를_입력한_경우() {
            String input = "3";

            assertThatThrownBy(() -> InputException.checkInputRestartValidation(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
