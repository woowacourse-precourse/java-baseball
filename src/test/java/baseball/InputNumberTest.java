package baseball;

import org.junit.jupiter.api.Test;

import java.io.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputNumberTest {

    @Test
    void inputGameNumber_공백_예외_테스트() {
        String input = "1 3";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertSimpleTest(() ->
                assertThatThrownBy(InputNumber::inputGameNumber)
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void inputGameNumber_세자리_아닌_수_예외_테스트() {
        String input = "2";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertSimpleTest(() ->
                assertThatThrownBy(InputNumber::inputGameNumber)
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void inputGameNumber_숫자가_아닐_때_예외_테스트() {
        String input = "1가2";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertSimpleTest(() ->
                assertThatThrownBy(InputNumber::inputGameNumber)
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void inputGameNumber_테스트() {
        String input = "123";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(input).isEqualTo(InputNumber.inputGameNumber());
    }

    @Test
    void inputRestartNumber_테스트() {
        String input = "1";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        System.out.println(input);

        assertThat(input).isEqualTo(InputNumber.inputRestartNumber());
    }

    @Test
    void inputRestartNumber_한자리_아닌_수_예외_테스트() {
        String input = "123";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertSimpleTest(() ->
                assertThatThrownBy(InputNumber::inputRestartNumber)
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void inputRestartNumber_숫자가_아닐_때_예외_테스트() {
        String input = "가";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertSimpleTest(() ->
                assertThatThrownBy(InputNumber::inputRestartNumber)
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void inputRestartNumber_공백_예외_테스트() {
        String input = " ";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertSimpleTest(() ->
                assertThatThrownBy(InputNumber::inputRestartNumber)
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void inputRestartNumber_중복_예외_테스트() {
        String input = "112";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertSimpleTest(() ->
                assertThatThrownBy(InputNumber::inputRestartNumber)
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}