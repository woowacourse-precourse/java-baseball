package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.Application.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    private Validations validations;
    private Processing processing ;


    @BeforeEach
    void getInstanceOfMethodClass(){
        this.validations = new Validations();
        this.processing = new Processing();
    }

    @Test
    void 입력값_Validation_Test(){
        // given
        String inputNum = "4234";

        // then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> validations.isCorrectInput(inputNum))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 입력값_Return_Test(){
        // given
        String inputNum = "423";
        List<String> answer = List.of("4","2","3");

        // then
        // readLine 메서드 특성상 테스트 시점에만 해당 메서드에 고정 값 지정 후 테스트 진행
        assertThat(answer).isEqualTo(processing.askInputNumber());
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
        main(new String[]{});
    }
}
