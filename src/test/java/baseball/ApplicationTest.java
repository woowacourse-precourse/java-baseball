package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.ByteArrayInputStream;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 서로_다른_랜덤넘버_생성() {
        List<Integer> randomNumbers = Input.generateNumbers();
        long distinctNumberCount = randomNumbers.stream().distinct().count();

        Assertions.assertEquals(3, distinctNumberCount);
    }

    @Test
    void 사용자_입력_받기_성공() {
        runTest(() -> {
            Input.getInput();
        }, "123");
    }

    @Test
    void 사용자_입력_받기_실패() {
        runTest(() -> {
            assertThatThrownBy(() -> Input.getInput())
                    .isInstanceOf(IllegalArgumentException.class);
        }, "1234");

        runTest(() -> {
            assertThatThrownBy(() -> Input.getInput())
                    .isInstanceOf(IllegalArgumentException.class);
        }, "abc");

        runTest(() -> {
            assertThatThrownBy(() -> Input.getInput())
                    .isInstanceOf(IllegalArgumentException.class);
        }, "1a2");
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

    private void runTest(final Executable executable, final String... args) {
        command(args);
        assertSimpleTest(executable);
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }
}
