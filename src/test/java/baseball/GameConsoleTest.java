package baseball;

import baseball.baseball.Digits;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameConsoleTest {

    @Nested
    class inputDigits {

        @Test
        @DisplayName("숫자배열을 제대로 입력한 경우")
        void caseSuccess() {
            GameConsole gameConsole = new GameConsole();
            String digitsString = "123";

            input(digitsString);
            Digits digits = gameConsole.inputDigits();

            assertThat(digits.getList()).isEqualTo(List.of(1, 2, 3));
        }

        @Test
        @DisplayName("숫자를 입력하지 않은 경우")
        void caseFail() {
            GameConsole gameConsole = new GameConsole();
            String digitsString = "abc";

            input(digitsString);

            assertThatThrownBy(gameConsole::inputDigits)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("숫자만 입력해주세요.");
        }
    }

    @Nested
    class inputShallReplay {

        @Test
        @DisplayName("1을 입력한 경우")
        void cassSuccess1() {
            GameConsole gameConsole = new GameConsole();

            input("1");
            boolean shallReplay = gameConsole.inputShallReplay();

            assertThat(shallReplay).isEqualTo(true);
        }

        @Test
        @DisplayName("2를 입력한 경우")
        void cassSuccess2() {
            GameConsole gameConsole = new GameConsole();

            input("2");
            boolean shallReplay = gameConsole.inputShallReplay();

            assertThat(shallReplay).isEqualTo(false);
        }

        @Test
        @DisplayName("1과 2이 아닌 값을 입력한 경우")
        void cassFail() {
            GameConsole gameConsole = new GameConsole();

            input("A");

            assertThatThrownBy(gameConsole::inputShallReplay)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("1과 2중 하나만 입력하세요");
        }
    }

    void input(String inputString) {
        InputStream in = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(in);
    }
}