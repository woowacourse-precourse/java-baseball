package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.Test;

public class NumberBaseBallGameTest {

    private ByteArrayOutputStream outputStreamCaptor;
    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    protected String getOutput() {
        return outputStreamCaptor.toString();
    }

    @Test
    void 낫싱_출력_테스트() {
        List<String> nothingCases = List.of(
                "312", "123", "789"
        );
        NumberBaseBallGame testGame = new NumberBaseBallGame(List.of(4, 5, 6));
        for (String nothing : nothingCases) {
            setUp();
            systemIn(nothing);
            testGame.getUserNumber();
            testGame.printNothing();
            assertThat(getOutput()).isEqualTo("낫싱");
        }
    }
    @Test
    void 스트라이크_출력_테스트() {
        List<String> noStrikeCases = List.of(
                "123", "789", "645", "564"
        );
        List<String> oneStrikeCases = List.of(
                "412", "465", "546", "126"
        );
        List<String> twoStrikeCases = List.of(
                "452", "457", "156", "426"
        );
        List<String> threeStrikeCases = List.of("456");
        strikePrintTest(noStrikeCases, "");
        strikePrintTest(oneStrikeCases, "1스트라이크");
        strikePrintTest(twoStrikeCases, "2스트라이크");
        strikePrintTest(threeStrikeCases, "3스트라이크");
    }
    void strikePrintTest(List<String> testCases, String expectOutPut) {
        NumberBaseBallGame testGame = new NumberBaseBallGame(List.of(4, 5, 6));
        for (String testCase : testCases) {
            setUp();
            systemIn(testCase);
            testGame.getUserNumber();
            testGame.printStrike();
            assertThat(getOutput()).isEqualTo(expectOutPut);
        }
    }
    @Test
    void 볼_출력_테스트() {
        List<String> noBallCases = List.of(
                "123", "456", "457", "412"
        );
        List<String> oneBallCases = List.of(
                "124", "461", "415", "146"
        );
        List<String> twoBallCases = List.of(
                "465", "654", "145", "546"
        );
        List<String> threeBallCases = List.of(
                "645", "564"
        );
        ballPrintTest(noBallCases, "");
        ballPrintTest(oneBallCases, "1볼");
        ballPrintTest(twoBallCases, "2볼");
        ballPrintTest(threeBallCases, "3볼");
    }
    void ballPrintTest(List<String> testCases, String expectOutPut) {
        NumberBaseBallGame testGame = new NumberBaseBallGame(List.of(4, 5, 6));
        for (String testCase : testCases) {
            setUp();
            systemIn(testCase);
            testGame.getUserNumber();
            testGame.printBall();
            assertThat(getOutput()).contains(expectOutPut);
        }
    }
    @Test
    void 게임_시행_테스트() {
        NumberBaseBallGame testGame = new NumberBaseBallGame(List.of(4, 5, 6));
        String input = "123\n124\n514\n564\n412\n461\n465\n451\n456\n";
        setUp();
        systemIn(input);
        testGame.play();
        assertThat(getOutput()).contains("숫자를 입력해주세요 : ")
                .contains("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                .contains("1볼 1스트라이크").contains("2볼 1스트라이크")
                .contains("3볼").contains("3스트라이크");
    }
}
