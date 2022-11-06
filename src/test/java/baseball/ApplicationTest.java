package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static baseball.Application.analyzeInput;
import static baseball.Application.selectRandomNumber;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    private ByteArrayOutputStream outputStreamCaptor;
    private PrintStream standardOut;

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    protected String getOutput() {
        return outputStreamCaptor.toString();
    }

    @BeforeEach
    void setUp() {
        standardOut = System.out;
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    protected void printResult() {
        System.setOut(standardOut);
        System.out.println(getOutput());
    }

    @Test
    @DisplayName("1. 컴퓨터가 서로 다른 임의의 수 3개 선택")
    void test1() {
        String randomNumber = selectRandomNumber();

        System.out.println("randomNumber = " + randomNumber);

        assertThat(randomNumber.charAt(0)).isNotEqualTo(randomNumber.charAt(1));
        assertThat(randomNumber.charAt(0)).isNotEqualTo(randomNumber.charAt(2));
        assertThat(randomNumber.charAt(1)).isNotEqualTo(randomNumber.charAt(2));
    }

    @Test
    @DisplayName("2. 사용자가 숫자를 입력")
    public void test2() {
        systemIn("123");
        Scanner scanner = new Scanner(System.in);
        assertThat(getOutput().equals("123"));
    }

    @Test
    @DisplayName("2-1. 숫자가 아닌 다른 입력인 경우")
    void test3() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("테스트")).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("2-2. 3자리 숫자가 아닌 입력인 경우")
    void test4() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("12")).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    @DisplayName("3-1. 맞는 숫자가 하나도 없는 경우 : 낫싱")
    void test5() {
        String analyzeResult1 = analyzeInput("456", "123");

        assertThat(analyzeResult1).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("3-2. 자리와 수가 모두 일치하는 경우 : 스트라이크")
    void test6() {
        String analyzeResult1 = analyzeInput("146", "123");
        String analyzeResult2 = analyzeInput("146", "143");
        String analyzeResult3 = analyzeInput("146", "146");

        assertThat(analyzeResult1).isEqualTo("1스트라이크");
        assertThat(analyzeResult2).isEqualTo("2스트라이크");
        assertThat(analyzeResult3).isEqualTo("3스트라이크");
    }

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
