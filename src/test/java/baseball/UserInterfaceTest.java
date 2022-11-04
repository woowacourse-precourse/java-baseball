package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.InputStreamAssert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class UserInterfaceTest {
    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Nested
    class 결과_출력_테스트 {
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
    class 게임_종료_재시작 {
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
}