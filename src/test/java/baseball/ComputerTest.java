package baseball;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class ComputerTest {
    private static Computer computer;
    private static Field field;

    @BeforeAll
    static void init() {
        computer = new Computer();
        computer.setAnswer();
        try {
            field = computer.getClass().getDeclaredField("answer");
            field.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private String getAnswer() {
        String answer = "";
        try {
            answer = (String) field.get(computer);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return answer;
    }

    private void setAnswer(String answer){
        try {
            field.set(computer, answer);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    void 정답_생성_테스트() {
        String answer = getAnswer();

        assertThat(answer).matches("[1-9]{3}");
        assertThat(answer.charAt(0)).isNotEqualTo(answer.charAt(1));
        assertThat(answer.charAt(0)).isNotEqualTo(answer.charAt(2));
        assertThat(answer.charAt(1)).isNotEqualTo(answer.charAt(2));
    }

    @Test
    void 스트라이크_결과_계산_테스트() {
        setAnswer("123");

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String input = "145";
        int score = computer.computeResult(input);

        assertThat(score).isEqualTo(1);
        assertThat(out.toString()).contains("1스트라이크");

        input = "124";
        score = computer.computeResult(input);

        assertThat(score).isEqualTo(2);
        assertThat(out.toString()).contains("2스트라이크");

        input = "123";
        score = computer.computeResult(input);

        assertThat(score).isEqualTo(3);
        assertThat(out.toString()).contains("3스트라이크");
    }

    @Test
    void 볼_결과_계산_테스트() {
        setAnswer("123");

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String input = "415";
        int score = computer.computeResult(input);

        assertThat(score).isEqualTo(0);
        assertThat(out.toString()).contains("1볼");

        input = "412";
        score = computer.computeResult(input);

        assertThat(score).isEqualTo(0);
        assertThat(out.toString()).contains("2볼");

        input = "312";
        score = computer.computeResult(input);

        assertThat(score).isEqualTo(0);
        assertThat(out.toString()).contains("3볼");
    }

    @Test
    void 볼_스트라이크_결과_계산_테스트() {
        setAnswer("123");

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String input = "142";
        int score = computer.computeResult(input);

        assertThat(out.toString()).contains("1볼 1스트라이크");
        assertThat(score).isEqualTo(1);

        input = "132";
        score = computer.computeResult(input);

        assertThat(out.toString()).contains("2볼 1스트라이크");
        assertThat(score).isEqualTo(1);
    }

    @Test
    void 낫싱_결과_계산_테스트() {
        setAnswer("123");

        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        String input = "456";
        int score = computer.computeResult(input);

        assertThat(out.toString()).contains("낫싱");
        assertThat(score).isEqualTo(0);
    }
}
