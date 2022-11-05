package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    @DisplayName("랜덤숫자가 서로다른 숫자를 가지고 있는지 확인")
    void createRandomTargetNum(){
        Application.createRandomTargetNum();
        Set<Integer> set = new HashSet<>(Application.targetNum);

        Assertions.assertThat(set.size()).isEqualTo(Application.targetNum.size());
    }

    @Test
    @DisplayName("랜덤숫자가 3개 선택되었는지 확인")
    void RandomNumSize(){
        Application.createRandomTargetNum();

        Assertions.assertThat(Application.targetNum.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("사용자 잘못된 값 입력시 오류 발생")
    void badInputException(){
        Assertions.assertThatThrownBy(()->
                Application.inputValidate(List.of("1234")))
                        .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(()->
                        Application.inputValidate(List.of("112")))
                .isInstanceOf(IllegalArgumentException.class);

        Assertions.assertThatThrownBy(()->
                        Application.inputValidate(List.of("103")))
                .isInstanceOf(IllegalArgumentException.class);


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
        try {
            Application.main(new String[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
