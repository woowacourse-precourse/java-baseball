package baseball;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest2 {

    @Nested
    class 숫자_검사_메소드_테스트 {
        @Test
        void case1() {
            List<Integer> numberList = List.of(1, 2, 3);
            boolean result = true;
            assertThat(Operator.isCorrectNumber(numberList)).isEqualTo(result);
        }

        @Test
        void case2() {
            List<Integer> numberList = List.of(1);
            boolean result = false;
            assertThat(Operator.isCorrectNumber(numberList)).isEqualTo(result);
        }

        @Test
        void case3() {
            List<Integer> numberList = List.of(1, 2, 2);
            boolean result = false;
            assertThat(Operator.isCorrectNumber(numberList)).isEqualTo(result);
        }

        @Test
        void case4() {
            List<Integer> numberList = List.of(1, 2, 0);
            boolean result = false;
            assertThat(Operator.isCorrectNumber(numberList)).isEqualTo(result);
        }
    }

    @Test
    void 랜덤_숫자_생성() {
        Computer computer = new Computer();
        computer.setNumber();
        assertThat(Operator.isCorrectNumber(computer.getNumber())).isEqualTo(true);
    }

    @Test
    void 사용자에게_숫자_입력받기() {
        Player player = new Player();
        String input = "123";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        player.inputNumber();
        List<Integer> result = List.of(1, 2, 3);
        assertThat(player.getNumber()).isEqualTo(result);
    }

}
