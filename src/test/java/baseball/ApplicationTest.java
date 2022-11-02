package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 입력시오류경우_확인(){

        Assertions.assertThatThrownBy(() ->{
            Application.isInputAlright("122");
            }).isInstanceOf(IllegalArgumentException.class);


        Assertions.assertThatThrownBy(() ->{
            Application.isInputAlright("1234");
        }).isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(() ->{
            Application.isInputAlright("12");
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 사용자와컴퓨터List에들어갔는지(){

        List<Integer> user = Application.inputProcess("123");
        List<Integer> compute = Application.computerRanmdomNumberExtract();

        Assertions.assertThat(user.size()).isEqualTo(3);
        Assertions.assertThat(compute.size()).isEqualTo(3);


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
