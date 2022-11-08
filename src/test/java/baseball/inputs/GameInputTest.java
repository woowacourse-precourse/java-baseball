package baseball.inputs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameInputTest{

    GameInput checkInput = new GameInput();
    @BeforeAll
    static void before(){
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    void computerMadeNumbers(){
        List<Integer> computerMadeNumbers = checkInput.computerMadeNumbers();
        int outputLength = 3;
        assertThat(computerMadeNumbers.size()).isEqualTo(outputLength);
    }

    @Test
    void haveSameNumbers_case1() {
        String input = "123";
        boolean output = false;
        assertThat(checkInput.haveSameNumbers(input)).isEqualTo(output);
    }

    @Test
    void haveSameNumbers_case2() {
        String input = "122";
        boolean output = true;
        assertThat(checkInput.haveSameNumbers(input)).isEqualTo(output);
    }

    @Test
    void haveSameNumbers_case3() {
        String input = "313";
        boolean output = true;
        assertThat(checkInput.haveSameNumbers(input)).isEqualTo(output);
    }
    @Test
    void checkingAgainInputTest_1(){
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(checkInput.checkingAgainInput()).isEqualTo(true);
    }

    @Test
    void checkingAgainInputTest_2(){
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(checkInput.checkingAgainInput()).isEqualTo(false);
    }

    @Test
    void checkingAgainInputTest_3(){
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> checkInput.checkingAgainInput())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkingAgainInputTest_4(){
        String input = "4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> checkInput.checkingAgainInput())
                .isInstanceOf(IllegalArgumentException.class);
    }
}