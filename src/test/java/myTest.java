import baseball.Application;
import baseball.ComputerNumGenerator;
import baseball.Game;
import baseball.UserNumGenerator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class myTest extends NsTest {
    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    void 컴퓨터_숫자가_정상적으로_생성되는지() {
        List<Integer> nums = new ComputerNumGenerator().NUMS;
        String num = nums.toString().replaceAll("[^1-9]","");
        boolean result = false;
        if (num.matches("[0-9]{3}") ) {
            result = true;
        }
        assertThat(result).isEqualTo(true);
    }

    @Test
    void 유저_숫자_검증1() {
        assertThatThrownBy(() -> new UserNumGenerator("12324"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저_숫자_검증2() {
        assertThatThrownBy(() -> new UserNumGenerator("012"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저_숫자_검증3() {
        assertThatThrownBy(() -> new UserNumGenerator("111"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유저_숫자가_정상일_때() {
        List<Integer> nums = new UserNumGenerator("153").NUMS;
        List<Integer> result = List.of(1, 5, 3);
        assertThat(result.toString()).isEqualTo(nums.toString());
    }

    @Test
    void 스트라이크_볼_검증() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("134", "194", "149", "159", "1", "123", "213", "234", "2");
                    assertThat(output()).contains("1스트라이크", "1볼 1스트라이크", "2스트라이크", "3스트라이크",
                            "2볼", "2볼", "3스트라이크", "게임 종료");
                },
                1, 5, 9, 2, 3, 4
        );
    }

    @Test
    void 재시작시_예외_검증() {
        assertThatThrownBy(() ->
                assertRandomNumberInRangeTest(
                        () -> {
                            run("134", "194", "149", "159", "3");
                            assertThat(output()).contains("1스트라이크", "1볼 1스트라이크", "2스트라이크", "3스트라이크", "게임 종료");
                        },
                        1, 5, 9
                )).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
