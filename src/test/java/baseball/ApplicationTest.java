package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.InstanceOfAssertFactories.ARRAY;

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

    @Test
    void 숫자_랜덤선택_테스트(){
        List<Integer> computer = Application.initComputer();
        boolean[] visited = new boolean[10];
        for (boolean i: visited)
            i = false;

        boolean flag = true;
        for (int i: computer){
            if(!(1<=i&&i<=9) && visited[i] == true){
                flag = false;
                break;
            }
            visited[i] = true;
        }

        assertThat(flag).isTrue();
    }

    @Test
    void 결과_판단_테스트(){
        List<Integer> computer, human;
        int[] result = new int[3];

        //낫싱
        computer = Arrays.asList(1, 2, 3);
        human = Arrays.asList(4, 5, 6);
        result[0] = result[1] = 0;
        result[2] = 1;
        assertThat(Application.match(computer, human))
                .isEqualTo(result);

        //1볼 1스트라이크
        computer = Arrays.asList(1, 2, 3);
        human = Arrays.asList(2, 5, 3);
        result[0] = result[1] = 1;
        result[2] = 0;
        assertThat(Application.match(computer, human))
                .isEqualTo(result);

        //1볼
        computer = Arrays.asList(1, 2, 3);
        human = Arrays.asList(2, 5, 6);
        result[0] = 1;
        result[1] = result[2] = 0;
        assertThat(Application.match(computer, human))
                .isEqualTo(result);

        //1스크라이크
        computer = Arrays.asList(1, 2, 3);
        human = Arrays.asList(4, 2, 6);
        result[0] = result[2] = 0;
        result[1] = 1;
        assertThat(Application.match(computer, human))
                .isEqualTo(result);

        //3스트라이크
        computer = Arrays.asList(1, 2, 3);
        human = Arrays.asList(1, 2, 3);
        result[1] = 3;
        result[0] = result[2] = 0;
        assertThat(Application.match(computer, human))
                .isEqualTo(result);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
