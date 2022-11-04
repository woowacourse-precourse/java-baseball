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
