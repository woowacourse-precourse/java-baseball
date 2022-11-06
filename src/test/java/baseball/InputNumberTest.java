package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class InputNumberTest {
    private static InputNumber inputNumber;

    @BeforeAll
    static void init(){
        inputNumber = new InputNumber();
    }

    @Test
    void 사용자_입력_세자리_숫자_공백_예외_테스트(){
        String input = "1 3";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputNumber.inputGameNumber())
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_입력_세자리_숫자_세자리_아닌_수_예외_테스트(){
        String input = "2";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputNumber.inputGameNumber())
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_입력_세자리_숫자_숫자가_아닐_때_예외_테스트(){
        String input = "1가2";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputNumber.inputGameNumber())
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_입력_세자리_숫자_테스트(){
        String input = "123";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(input).isEqualTo(inputNumber.inputGameNumber());
    }

    @Test
    void 사용자_입력_재시작_숫자_테스트(){
        String input = "1";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        System.out.println(input);
        assertThat(input).isEqualTo(inputNumber.inputRestartNumber());
    }

    @Test
    void 사용자_입력_재시작_숫자_한자리_아닌_수_예외_테스트(){
        String input = "123";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputNumber.inputRestartNumber())
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_입력_재시작_숫자_숫자가_아닐_때_예외_테스트(){
        String input = "가";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputNumber.inputRestartNumber())
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 사용자_입력_재시작_숫자_공백_예외_테스트(){
        String input = " ";
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertSimpleTest(() ->
                assertThatThrownBy(() -> inputNumber.inputRestartNumber())
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

}