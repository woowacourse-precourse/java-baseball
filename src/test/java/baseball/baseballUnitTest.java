package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class baseballUnitTest {

    @Nested
    @DisplayName("유저 입력값 검증")
    class InputTest{
        @Test
        @DisplayName("유저 입력값 숫자 2개")
        void 적은입력() {
            assertThatThrownBy(() -> new User("12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 3개 입력하세요");
        }

        @Test
        @DisplayName("유저 입력값 숫자 4개")
        void 많은입력() {
            assertThatThrownBy(() -> new User("1234"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 3개 입력하세요");
        }

        @Test
        @DisplayName("유저 입력값 형식 오류")
        void 문자입력() {
            assertThatThrownBy(() -> new User("12a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력하세요");
        }

        @Test
        @DisplayName("중복 숫자 입력")
        void 중복숫자() {
            assertThatThrownBy(() -> new User("121"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자가 있습니다");
        }

        @Test
        @DisplayName("음수 입력")
        void 음수입력() {
            assertThatThrownBy(() -> new User("-12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양수만 입력하세요");
        }
    }

    @Nested
    @DisplayName("게임 기능 검증")
    class baseballGameTest {
        @Test
        @DisplayName("컴퓨터의 숫자와 유저입력값 비교")
        void 중복숫자() {
            assertThatThrownBy(() -> new User("121"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복된 숫자가 있습니다");
        }

    }


}
