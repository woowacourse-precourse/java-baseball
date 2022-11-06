package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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


    //TODO : 테스트 코드

    @Test
    @DisplayName("입력의 길이가 3이 아닌 경우 ")
    public void inputLenNot3() throws Exception{
        assertThatThrownBy(()-> Application.validationAndConvert("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("서로 다른 3개의 수가 아닌 경우")
    public void duplicationNumber() throws Exception{
        assertThatThrownBy(()-> Application.validationAndConvert("133"))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("수가 아닌 입력이 있는 경우")
    public void NotNumber() throws Exception{
       assertThatThrownBy(()->Application.validationAndConvert("a12"))
               .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("정상 입력인 경우 ")
    public void NormalInput() throws Exception{
        List<Integer> result = Application.validationAndConvert("123");
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0)).isEqualTo(1);
        assertThat(result.get(1)).isEqualTo(2);
        assertThat(result.get(2)).isEqualTo(3);

    }
}
