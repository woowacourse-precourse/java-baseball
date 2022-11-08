package Implement;

import baseball.Application;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.assertj.core.api.Assertions.assertThat;


public class FunctionTest extends NsTest {

    @Test
    @DisplayName("랜덤 숫자를 생성하는 리스트에 3자리가 생성되는지 확인")
    void 리스트에_3자리_생성() {
        List<Integer> randomNumber = Application.Game.makeRandomNumberList();
        assertThat(randomNumber.size() == 3);
    }

    @Test
    @DisplayName("랜덤 숫자를 생성하는 리스트에 있는 3자리의 숫자가 1부터 9까지의 숫자 중에 서로 다른 수가 들어가 있는지 확인")
    void 서로_다른_수_3자리를_1부터_9까지_랜덤으로_생성() {
        List<Integer> randomNumber = Application.Game.makeRandomNumberList();
        assertNotEquals(randomNumber.get(0), randomNumber.get(1));
        assertNotEquals(randomNumber.get(0), randomNumber.get(2));
        assertNotEquals(randomNumber.get(1), randomNumber.get(2));
    }

    @Test
    @DisplayName("player의 입력값과 컴퓨터의 랜덤값을 비교해 보았을 때 \"1볼 1스트라이크\"가 나와야 하는 상황에 맞게 잘 출력 되는지 확인")
    void 힌트_출력_여부_낫싱_제외() {
        List<Integer> computer = List.of(1, 2, 3);
        List<String> player = List.of("1", "3", "4");
        String giveHint = Application.Game.checkAnswer(computer,player);
        assertThat(giveHint).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("player의 입력값과 컴퓨터의 랜덤값을 비교해 보았을 때 모두 다른 값이므로 \"낫싱\"이 잘 출력되는지 확인")
    void 힌트_출력_여부_낫싱() {
        List<Integer> computer = List.of(1, 2, 3);
        List<String> player = List.of("4", "5", "6");
        String giveHint = Application.Game.checkAnswer(computer,player);
        assertThat(giveHint).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("정답일 경우 종료가 된 후 재시작할 것인지 완전 종료할 것인지 묻고 완전 종료 선택이 가능한지 확인")
    void 완전_종료_여부() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "2");
                    assertThat(output()).contains("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    assertThat(output()).contains("게임을 종료합니다.");
                },
                1, 2, 3
        );
    }

    @Test
    @DisplayName("아무 숫자도 입력하지 않았을 때 \"IllegalArgumentException\"을 반환하는지 확인")
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
