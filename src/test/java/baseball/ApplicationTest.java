package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

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
    public void checkInputConditionTest_NormalCase() throws Exception{
        //given
        int inputNumber = 123;
        //when
        //then
        assertThatThrownBy(() -> Application.checkInputCondition(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
     }
    @Test
    public void checkInputConditionTest_MoreDigits() throws Exception{
        //given
        int inputNumber = 1234;
        //when
        //then
        assertThatThrownBy(() -> Application.checkInputCondition(inputNumber))
                .isInstanceOf(IllegalArgumentException.class);
     }

     @Test
     public void checkInputConditionTest_LessDigits() throws Exception{
         //given
         int inputNumber = 12;
         //when
         //then
         assertThatThrownBy(() -> Application.checkInputCondition(inputNumber))
                 .isInstanceOf(IllegalArgumentException.class);
      }

     @Test
     public void checkInputConditionTest_RedundantNumber() throws Exception{
         //given
         int inputNumber = 122;
         //when
         //then
         assertThatThrownBy(() -> Application.checkInputCondition(inputNumber))
                 .isInstanceOf(IllegalArgumentException.class);
      }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
