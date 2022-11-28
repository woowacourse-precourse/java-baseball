package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.*;

public class IOTest {

    @Nested
    class UserInputTest {

        @DisplayName("정상 입력 테스트")
        @Test
        void normalInput() {
            InputStream stdIn = System.in;
            System.setIn(new ByteArrayInputStream("413".getBytes()));
            assertThatCode(IO::userInput).doesNotThrowAnyException();
        }

        @DisplayName("문자를 포함한 입력은 예외를 발생시켜야 한다.")
        @Test
        void invalidInputTest1() {
            InputStream stdIn = System.in;
            System.setIn(new ByteArrayInputStream("d13".getBytes()));
            assertThatThrownBy(IO::userInput).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("3자리 숫자가 아닌 입력은 예외를 발생시킨다.")
        @Test
        void invalidInputTest2() {
            InputStream stdIn = System.in;
            System.setIn(new ByteArrayInputStream("13".getBytes()));
            assertThatThrownBy(IO::userInput).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("0이 포함된 입력은 예외를 발생시킨다.")
        @Test
        void invalidInputTest3() {
            InputStream stdIn = System.in;
            System.setIn(new ByteArrayInputStream("013".getBytes()));
            assertThatThrownBy(IO::userInput).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("중복된 숫자가 포함될 경우 예외를 발생시켜야 한다.")
        @Test
        void invalidInputTest4() {
            InputStream stdIn = System.in;
            System.setIn(new ByteArrayInputStream("733".getBytes()));
            assertThatThrownBy(IO::userInput).isInstanceOf(IllegalArgumentException.class);
        }
    }


    @Nested
    class RetryInputTest {
        @DisplayName("정상 입력 테스트")
        @Test
        void normalInput() {
            InputStream stdIn = System.in;
            System.setIn(new ByteArrayInputStream("1".getBytes()));
            assertThatCode(IO::retryInput).doesNotThrowAnyException();
        }

        @DisplayName("문자 입력시 예외가 발생해야 한다.")
        @Test
        void invalidInputTest1() {
            InputStream stdIn = System.in;
            System.setIn(new ByteArrayInputStream("d".getBytes()));
            assertThatThrownBy(IO::retryInput).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("1과 2가 아닌 숫자의 입력은 예외가 발생해야 한다.")
        @Test
        void invalidInputTest2() {
            InputStream stdIn = System.in;
            System.setIn(new ByteArrayInputStream("0".getBytes()));
            assertThatThrownBy(IO::retryInput).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("두자리 이상의 입력은 예외가 발생해야 한다.")
        @Test
        void invalidInputTest3() {
            InputStream stdIn = System.in;
            System.setIn(new ByteArrayInputStream("12".getBytes()));
            assertThatThrownBy(IO::retryInput).isInstanceOf(IllegalArgumentException.class);
        }
    }



    @Nested
    class PrintResultTest {

        @Test
        void printResult() {
            //given
            OutputStream stdOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(stdOut));
            IO.printResult(2, 1);

            //then
            assertThat("2볼 1스트라이크").isEqualTo(stdOut.toString().trim());
        }
    }
}
