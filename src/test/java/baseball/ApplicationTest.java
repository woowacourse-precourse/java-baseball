package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static baseball.Application.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

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
    void 예외_테스트2(){
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("ABCD"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 컴퓨터가_세개의_수를_뽑는지(){
        assertThat(generateComputerNum().size()).isEqualTo(3);
    }

    @Test
    void 유저의_숫자들이_리스트로_저장되었는지(){
        String num="123";
        assertThat(splitUserNumToList(num)).containsExactly(1,2,3);
    }

    @Test
    void 전체_결과_판정() {
        List<Integer> computerNumList = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> userNumList1= new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> userNumList2= new ArrayList<>(Arrays.asList(4,5,6));
        List<Integer> userNumList3= new ArrayList<>(Arrays.asList(1,3,2));

        assertThat(judge(computerNumList, userNumList1)).isEqualTo("3스트라이크");
        assertThat(judge(computerNumList, userNumList2)).isEqualTo("낫싱");
        assertThat(judge(computerNumList, userNumList3)).isEqualTo("2볼 1스트라이크");
    }

    @Test
    void 볼_판정(){
        List<Integer> computerNumList = new ArrayList<>(Arrays.asList(1,2,3));
        List<Integer> userNumList= new ArrayList<>(Arrays.asList(1,3,2));

        assertThat(judgeBall(computerNumList,userNumList)).isEqualTo(2);
    }




    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
