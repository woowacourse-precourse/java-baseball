package baseball.domain.input;

import baseball.controller.GameFlag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConsoleInputReaderTest {
    @DisplayName("사용자 입력 검증 (야구 게임)")
    @Nested
    class baseballInput {
        @DisplayName("각 자리수가 char 에서 Integer 형으로 변환된다")
        @Test
        void charToInteger() {
            //given
            char numChar = '1';

            //when
            Integer integer = ConsoleInputReader.convertCharToInteger(numChar);

            //then
            assertThat(integer).isInstanceOf(Integer.class);
            assertThat(integer).isEqualTo(1);
        }

        @DisplayName("각 자리수를 나누어 List<Integer> 형태로 반환한다.")
        @Test
        void getUserBaseballNumber() {
            //given
            String number1 = "142";
            String number2 = "827";

            //when
            List<Integer> numberIntegerList1 = ConsoleInputReader.convertToIntegerList(number1);
            List<Integer> numberIntegerList2 = ConsoleInputReader.convertToIntegerList(number2);

            //then
            assertThat(numberIntegerList1.get(0)).isEqualTo(1);
            assertThat(numberIntegerList1.get(1)).isEqualTo(4);
            assertThat(numberIntegerList1.get(2)).isEqualTo(2);

            assertThat(numberIntegerList2.get(0)).isEqualTo(8);
            assertThat(numberIntegerList2.get(1)).isEqualTo(2);
            assertThat(numberIntegerList2.get(2)).isEqualTo(7);
        }

        @DisplayName("예외 검증")
        @Nested
        class exceptional {
            @DisplayName("입력받은 데이터의 길이가 3글자가 아닌 경우 예외가 발생한다.")
            @Test
            void exception1() {
                assertThrows(IllegalArgumentException.class, () -> ConsoleInputReader.convertToIntegerList("12"));
                assertThrows(IllegalArgumentException.class, () -> ConsoleInputReader.convertToIntegerList("823415"));
            }

            @DisplayName("입력받은 데이터에 숫자가 아닌 다른 문자가 있을 경우 예외가 발생한다.")
            @Test
            void exception2() {
                assertThrows(IllegalArgumentException.class, () -> ConsoleInputReader.convertToIntegerList("12a"));
                assertThrows(IllegalArgumentException.class, () -> ConsoleInputReader.convertToIntegerList("r13"));
            }

            @DisplayName("입력받은 데이터에 0이 포함되어 있을 경우 예외가 발생한다.")
            @Test
            void exception3() {
                assertThrows(IllegalArgumentException.class, () -> ConsoleInputReader.convertToIntegerList("120"));
                assertThrows(IllegalArgumentException.class, () -> ConsoleInputReader.convertToIntegerList("013"));
            }
        }
    }

    @DisplayName("사용자 입력 검증 (다시시작 | 종료)")
    @Nested
    class flagTest {
        @DisplayName("'1'을 입력하면 START 가 반환된다")
        @Test
        void start() {
            //given
            String userFlag = "1";
            InputStream in = new ByteArrayInputStream(userFlag.getBytes());
            System.setIn(in);

            //when
            GameFlag gameFlag = ConsoleInputReader.getUserOpinion();

            //then
            assertThat(gameFlag).isEqualTo(GameFlag.START);
        }

        @DisplayName("'2'을 입력하면 START 가 반환된다")
        @Test
        void end() {
            //given
            String userFlag = "2";
            InputStream in = new ByteArrayInputStream(userFlag.getBytes());
            System.setIn(in);

            //when
            GameFlag gameFlag = ConsoleInputReader.getUserOpinion();

            //then
            assertThat(gameFlag).isEqualTo(GameFlag.END);
        }

        @DisplayName("'1', '2' 이외의 값을 입력할 경우 예외가 발생한다")
        @Test
        void exception1() {
            //given
            String userFlag = "d";
            InputStream in = new ByteArrayInputStream(userFlag.getBytes());
            System.setIn(in);

            //then
            assertThrows(IllegalArgumentException.class, ConsoleInputReader::getUserOpinion);
        }

        @DisplayName("'1', '2' 이외의 값을 입력할 경우 예외가 발생한다")
        @Test
        void exception2() {
            //given
            String userFlag = "3";
            InputStream in = new ByteArrayInputStream(userFlag.getBytes());
            System.setIn(in);

            //then
            assertThrows(IllegalArgumentException.class, ConsoleInputReader::getUserOpinion);
        }
    }
}