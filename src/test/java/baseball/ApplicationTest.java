package baseball;

import camp.nextstep.edu.missionutils.test.Assertions;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
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

    //정리한 기능 목록 정상 동작 테스트
    //게임시작기능 테스트
    @Test
    void 게임시작_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Application.gameStart())
                        .isNotNull()
        );
    }

    @Test
    void 랜덤숫자부여_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    List<Integer> result = Application.randomNum();
                    assertThat(result).contains(1, 3, 5);
                },
                1, 3, 5
        );
    }

    @Test
    void 게임종료_출력_테스트() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Application.gameExit();

        assertThat("프로그램을 종료합니다.\n").isEqualTo(out.toString());
    }

    //todo: 숫자를 입력받는 기능 테스트
    @Test
    void 숫자를_입력받는_기능_테스트() {
        String input_num = "123";
        InputStream in = new ByteArrayInputStream(input_num.getBytes());
        System.setIn(in);
        int result = Application.int_input();

        assertThat(result).isEqualTo(123);

    }

    //입력받은 숫자 배열로 변환
    @Test
    void 입력받은_숫자를_배열로_변환하는_기능_테스트() {
        int input_num = 123;
        List<Integer> result = Application.input_num_list(input_num);

        assertThat(result).contains(1, 2, 3);
    }

    @Test
    void 스트라이크_개수_구하는_기능_테스트() {
        List<Integer> input_num_list = Arrays.asList(1, 2, 3);
        List<Integer> computer = Arrays.asList(1, 2, 3);
        int result = Application.strike(input_num_list, computer);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void 볼_개수_구하는_기능_테스트() {
        List<Integer> input_num_list = Arrays.asList(3, 2, 1);
        List<Integer> computer = Arrays.asList(1, 2, 3);
        int result = Application.ball(input_num_list, computer);

        assertThat(result).isEqualTo(2);
    }

    @Test
    void 낫싱_개수_구하는_기능_테스트() {
        List<Integer> input_num_list = Arrays.asList(4, 5, 6);
        List<Integer> computer = Arrays.asList(1, 2, 3);
        int result = Application.nothing(input_num_list, computer);

        assertThat(result).isEqualTo(3);
    }

    @Test
    void 숫자_검증과_출력_기능_테스트() {
        int strike = 3;
        int ball = 0;
        int nothing = 0;
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Application.print_verification(strike, ball, nothing);

        assertThat("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n").isEqualTo(out.toString());
    }

    @Test
    void 게임종료_여부_선택기능_테스트() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int result = Application.exit();

        assertThat(result).isEqualTo(1);
    }
}
