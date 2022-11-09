package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


class ApplicationTest extends NsTest {
    public static final int TARGET_LENGTH = Application.TARGET_LENGTH;
    public static final int MIN_INT = Application.MIN_INT;
    public static final int MAX_INT = Application.MAX_INT;
    public static final int BALL_INT = Application.BALL_INT;
    public static final int STRIKE_INT = Application.STRIKE_INT;
    public static final int NOTHING_INT = Application.NOTHING_INT;
    final ByteArrayOutputStream newOut = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @Test
    void overallTest_많은_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
        assertRandomNumberInRangeTest(
                () -> {
                    run("135", "1", "589", "1", "751", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9, 7, 5, 1
        );
    }

    @Test
    void overallTest_적은_출력() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("135", "1", "123", "589", "2");
                    assertThat(output()).contains("3스트라이크", "낫싱", "게임 종료");
                    assertThat(output()).doesNotContain("1스트라이크", "2스트라이크", "볼");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void createTargetNumber_정상_생성_확인() {
        assertRandomNumberInRangeTest(
                () -> {
                    List<Integer> result = Application.createTargetNumber();
                    assertThat(result).contains(2, 4, 7);
                    assertThat(result).containsExactly(4, 7, 2);
                },
                4, 7, 2
        );
    }

    @Test
    void createTargetNumber_정상_생성_확인_중복_제거() {
        assertRandomNumberInRangeTest(
                () -> {
                    List<Integer> result = Application.createTargetNumber();
                    assertThat(result).contains(1, 3, 8);
                    assertThat(result).containsExactly(3, 1, 8);
                },
                3, 1, 3, 1, 1, 1, 3, 1, 3, 1, 1, 1, 8
        );
    }

    @RepeatedTest(50)
    void createTargetNumber_생성_결과_유효성_확인() {
        assertSimpleTest(
                () -> {
                    List<Integer> result = Application.createTargetNumber();
                    assertAll(
                            () -> assertThat(result.size()).isEqualTo(3),
                            () -> assertThat(new HashSet<>(result).size()).isEqualTo(TARGET_LENGTH),
                            () -> {
                                for (int num : result) {
                                    assertThat(num).isBetween(MIN_INT, MAX_INT);
                                }
                            }
                    );
                }
        );
    }

    @Test
    void verifyInput_길이_예외_확인() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input value must be a three-digit natural number : 1234"));
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("77"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input value must be a three-digit natural number : 77"));
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input value must be a three-digit natural number : 0"));
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input value must be a three-digit natural number : "));
    }

    @Test
    void verifyInput_숫자_예외_확인() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("3 a"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input value must be a three-digit natural number : 3 a"));
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("out"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input value must be a three-digit natural number : out"));
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("703"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input value must be a three-digit natural number : 703"));
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("우테코"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Input value must be a three-digit natural number : 우테코"));
    }

    @Test
    void verifyInput_중복_예외_확인() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("337"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Each digit of input value should be unique : 337"));
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("737"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Each digit of input value should be unique : 737"));
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("377"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Each digit of input value should be unique : 377"));
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("444"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("Each digit of input value should be unique : 444"));
    }

    @Test
    void verifyInput_정상_작동_확인() {
        assertSimpleTest(() ->
                assertDoesNotThrow(() -> runException("389")));
        assertSimpleTest(() ->
                assertDoesNotThrow(() -> runException("147")));
        assertSimpleTest(() ->
                assertDoesNotThrow(() -> runException("798")));
        assertSimpleTest(() ->
                assertDoesNotThrow(() -> runException("456")));
        assertSimpleTest(() ->
                assertDoesNotThrow(() -> runException("123")));
    }

    @Test
    void judgeEachNumber_볼_확인() {
        final List<Integer> target = new ArrayList<>(List.of(5, 3, 7));
        assertAll(
                () -> assertThat(Application.judgeEachNumber(target, 0, 3)).isEqualTo(BALL_INT),
                () -> assertThat(Application.judgeEachNumber(target, 0, 7)).isEqualTo(BALL_INT),
                () -> assertThat(Application.judgeEachNumber(target, 1, 5)).isEqualTo(BALL_INT),
                () -> assertThat(Application.judgeEachNumber(target, 1, 7)).isEqualTo(BALL_INT),
                () -> assertThat(Application.judgeEachNumber(target, 2, 5)).isEqualTo(BALL_INT),
                () -> assertThat(Application.judgeEachNumber(target, 2, 3)).isEqualTo(BALL_INT)
        );
    }

    @Test
    void judgeEachNumber_스트라이크_확인() {
        final List<Integer> target = new ArrayList<>(List.of(4, 9, 1));
        assertAll(
                () -> assertThat(Application.judgeEachNumber(target, 0, 4)).isEqualTo(STRIKE_INT),
                () -> assertThat(Application.judgeEachNumber(target, 1, 9)).isEqualTo(STRIKE_INT),
                () -> assertThat(Application.judgeEachNumber(target, 2, 1)).isEqualTo(STRIKE_INT)
        );
    }

    @Test
    void judgeEachNumber_낫싱_확인() {
        final List<Integer> target = new ArrayList<>(List.of(8, 7, 6));
        assertAll(
                () -> assertThat(Application.judgeEachNumber(target, 0, 1)).isEqualTo(NOTHING_INT),
                () -> assertThat(Application.judgeEachNumber(target, 1, 2)).isEqualTo(NOTHING_INT),
                () -> assertThat(Application.judgeEachNumber(target, 2, 3)).isEqualTo(NOTHING_INT)
        );
    }

    @Test
    void printResult_확인() {
        System.setOut(new PrintStream(newOut));
        Application.printResult(new ArrayList<>(List.of(0, 0)));
        assertThat(newOut.toString().trim()).isEqualTo("낫싱");
        newOut.reset();

        Application.printResult(new ArrayList<>(List.of(1, 0)));
        assertThat(newOut.toString().trim()).isEqualTo("1볼");
        newOut.reset();

        Application.printResult(new ArrayList<>(List.of(2, 0)));
        assertThat(newOut.toString().trim()).isEqualTo("2볼");
        newOut.reset();

        Application.printResult(new ArrayList<>(List.of(3, 0)));
        assertThat(newOut.toString().trim()).isEqualTo("3볼");
        newOut.reset();

        Application.printResult(new ArrayList<>(List.of(0, 1)));
        assertThat(newOut.toString().trim()).isEqualTo("1스트라이크");
        newOut.reset();

        Application.printResult(new ArrayList<>(List.of(1, 1)));
        assertThat(newOut.toString().trim()).isEqualTo("1볼 1스트라이크");
        newOut.reset();

        Application.printResult(new ArrayList<>(List.of(2, 1)));
        assertThat(newOut.toString().trim()).isEqualTo("2볼 1스트라이크");
        newOut.reset();

        Application.printResult(new ArrayList<>(List.of(0, 2)));
        assertThat(newOut.toString().trim()).isEqualTo("2스트라이크");
        newOut.reset();

        Application.printResult(new ArrayList<>(List.of(1, 2)));
        assertThat(newOut.toString().trim()).isEqualTo("1볼 2스트라이크");
        newOut.reset();

        Application.printResult(new ArrayList<>(List.of(0, 3)));
        assertThat(newOut.toString().trim()).isEqualTo("3스트라이크");
        newOut.reset();

        System.setOut(standardOut);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
