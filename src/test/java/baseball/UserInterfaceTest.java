package baseball;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class UserInterfaceTest {
    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Nested
    class ResultOutput {
        @Test
        void 스트라이크3() {
            assertThat(UserInterface.resultOutput(3, 0)).isEqualTo(true);
        }

        @Test
        void 스트라이크1볼1() {
            assertThat(UserInterface.resultOutput(1, 1)).isEqualTo(false);
        }

        @Test
        void 스트라이크1() {
            assertThat(UserInterface.resultOutput(1, 0)).isEqualTo(false);
        }

        @Test
        void 볼1() {
            assertThat(UserInterface.resultOutput(0, 1)).isEqualTo(false);
        }

        @Test
        void 낫싱() {
            assertThat(UserInterface.resultOutput(0, 0)).isEqualTo(false);
        }
    }

    @Nested
    class ExitOrRestart {
        @Test
        void 게임_재시작() {
            System.setIn(generateUserInput("1"));
            boolean result = UserInterface.exitOrRestart();
            assertThat(result).isFalse();
        }

        @Test
        void 게임_종료() {
            System.setIn(generateUserInput("2"));
            boolean result = UserInterface.exitOrRestart();
            assertThat(result).isTrue();
        }

        @Test
        void 잘못된_입력_에러() {
            System.setIn(generateUserInput("aa"));
            assertThatThrownBy(UserInterface::exitOrRestart).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class getUsersAnswer {
        @Test
        void 올바른_사용자_입력_테스트() {
            System.setIn(generateUserInput("123"));
            List<Integer> usersAnswer = UserInterface.getUsersAnswer();
            List<Integer> answer = List.of(1, 2, 3);
            assertThat(usersAnswer).isEqualTo(answer);
        }

        @Test
        void 문자가_포함된_입력() {
            System.setIn(generateUserInput("3a4"));
            assertThatThrownBy(UserInterface::getUsersAnswer).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 길이가_3_미만인_입력() {
            System.setIn(generateUserInput(""));
            assertThatThrownBy(UserInterface::getUsersAnswer).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 중복된_숫자_입력() {
            System.setIn(generateUserInput("121"));
            assertThatThrownBy(UserInterface::getUsersAnswer).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 길이가_3_이상이고_중복된_숫자_입력() {
            System.setIn(generateUserInput("112233"));
            assertThatThrownBy(UserInterface::getUsersAnswer).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 숫자_0이_포함된_입력() {
            System.setIn(generateUserInput("120"));
            assertThatThrownBy(UserInterface::getUsersAnswer).isInstanceOf(IllegalArgumentException.class);
        }
    }
}