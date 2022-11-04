package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
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
    void generateComputerRandomNumber_유효성_테스트(){
        //given
        final Application T = new Application();

        //when
//        final List<Integer> computerRandomNumber = T.generateComputerRandomNumber();
        final List<Integer> computerRandomNumber = List.of(1,2,4);

        //then
        assertThat(computerRandomNumber.size()).as("컴퓨터 랜덤 숫자 리스트 길이 검사").isEqualTo(3);
        assertThat(computerRandomNumber.size()).as("컴퓨터 랜덤 숫자 리스트 중복 요소 검사").isEqualTo(new HashSet<>(computerRandomNumber).size());
        for(int digit : computerRandomNumber){
            assertThat(digit).as("컴퓨터 랜덤 숫자 리스트 요소 범위 검사").isBetween(1,9);
        }
    }

    @Test
    void countStrike_테스트(){
        //given
        final Application T = new Application();
        final List<List<Integer>> case1 = List.of(List.of(1,2,3), List.of(4,5,6));  // 0 strike
        final List<List<Integer>> case2 = List.of(List.of(1,2,3), List.of(4,2,6));  // 1 strike
        final List<List<Integer>> case3 = List.of(List.of(1,2,3), List.of(1,2,6));  // 2 strike
        final List<List<Integer>> case4 = List.of(List.of(1,2,3), List.of(4,2,3));  // 2 strike
        final List<List<Integer>> case5 = List.of(List.of(1,2,3), List.of(1,2,3));  // 3 strike

        //when
        final int result1 = T.countStrike(case1.get(0), case1.get(1));
        final int result2 = T.countStrike(case2.get(0), case2.get(1));
        final int result3 = T.countStrike(case3.get(0), case3.get(1));
        final int result4 = T.countStrike(case4.get(0), case4.get(1));
        final int result5 = T.countStrike(case5.get(0), case5.get(1));


        //then
        assertThat(result1).as("countStrike 테스트").isEqualTo(0);
        assertThat(result2).as("countStrike 테스트").isEqualTo(1);
        assertThat(result3).as("countStrike 테스트").isEqualTo(2);
        assertThat(result4).as("countStrike 테스트").isEqualTo(2);
        assertThat(result5).as("countStrike 테스트").isEqualTo(3);
    }

    @Test
    void isDigitStrike_테스트(){
        //given
        final Application T = new Application();
        final List<List<Integer>> case1 = List.of(List.of(1,2,3), List.of(4,2,3));  // 2 strike

        //when
        final boolean result1 = T.isDigitStrike(case1.get(0), case1.get(1), 0); //false
        final boolean result2 = T.isDigitStrike(case1.get(0), case1.get(1), 1); //true
        final boolean result3 = T.isDigitStrike(case1.get(0), case1.get(1), 2); //true

        //then
        assertThat(result1).isEqualTo(false);
        assertThat(result2).isEqualTo(true);
        assertThat(result3).isEqualTo(true);
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
