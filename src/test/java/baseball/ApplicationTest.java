package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output())
                            .contains(
                                    "낫싱",
                                    "3스트라이크",
                                    "1볼 1스트라이크",
                                    "3스트라이크",
                                    "게임 종료");
                },
                1,
                3,
                5,
                5,
                8,
                9);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("1234"))
                .isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    public void runMain() {
        Application.main(new String[] {});
    }

    @Test
    public void testIsInputDuplicated() {
        InputValidator testClass = new InputValidator("133");
        assertThat(testClass.isInputDuplicated()).isEqualTo(false);
    }

    @Test
    public void testIsRightLength() {
        InputValidator testClass = new InputValidator("12");
        assertThat(testClass.isRightLength()).isEqualTo(false);
    }

    @Test
    public void testIsRightNumber() {
        InputValidator testClass = new InputValidator("-121");
        assertThat(testClass.isRightNumber()).isEqualTo(false);
    }

    @Test
    public void testInputValidator() {
        InputValidator testClass = new InputValidator("356");
        assertThat(testClass.checkInput()).isEqualTo(true);
    }

    @Test
    public void testComputer() {
        Computer com = new Computer();
        com.createNumber();
        InputValidator testClass = new InputValidator(com.getAnswer());
        System.out.println(com.getAnswer());
        assertThat(testClass.checkInput()).isEqualTo(true);
    }

    @Test
    public void testGetScore() {
        Judge testJudge = new Judge();
        testJudge.setAnswerToJudge("123", "143");
        testJudge.getScore();
        assertThat(testJudge.makeResultString()).isEqualTo("2 스트라이크");
    }
}
