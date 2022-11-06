package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
    @DisplayName(" 정상 입력인 경우 ")
    public void NormalInput() throws Exception{
        List<Integer> result = Application.validationAndConvert("123");
        assertThat(result.size()).isEqualTo(3);
        assertThat(result.get(0)).isEqualTo(1);
        assertThat(result.get(1)).isEqualTo(2);
        assertThat(result.get(2)).isEqualTo(3);

    }


    @Test
    @DisplayName(" 0 볼 경우 ")
    public void zeroBallScenario() throws Exception{
        List<Integer> computer  = List.of(1,2,3);
        List<Integer> user = List.of(4,5,6);

        int ball = Application.calculationBall(computer,user);
        assertThat(ball).isEqualTo(0);
    }

    @Test
    @DisplayName(" 1 볼 경우 ")
    public void oneBallScenario() throws Exception{
        List<Integer> computer  = List.of(1,4,3);
        List<Integer> user = List.of(4,5,6);

        int ball = Application.calculationBall(computer,user);
        assertThat(ball).isEqualTo(1);
    }
    @Test
    @DisplayName(" 2 볼 경우 ")
    public void twoBallScenario() throws Exception{
        List<Integer> computer  = List.of(1,4,5);
        List<Integer> user = List.of(4,5,6);

        int ball = Application.calculationBall(computer,user);
        assertThat(ball).isEqualTo(2);
    }
    @Test
    @DisplayName(" 3 볼 경우 ")
    public void threeBallScenario() throws Exception{
        List<Integer> computer  = List.of(6,4,5);
        List<Integer> user = List.of(4,5,6);

        int ball = Application.calculationBall(computer,user);
        assertThat(ball).isEqualTo(3);
    }



    @Test
    @DisplayName("0 스트라이크 경우 ")
    public void noStrikeScenario() throws Exception{
        List<Integer> computer  = List.of(1,2,5);
        List<Integer> user = List.of(4,5,6);

        int strike = Application.calculationStrike(computer,user);
        assertThat(strike).isEqualTo(0);

    }

    @Test
    @DisplayName("1 스트라이크 경우 ")
    public void oneStrikeScenario() throws Exception{
        List<Integer> computer  = List.of(1,5,4);
        List<Integer> user = List.of(4,5,6);

        int strike = Application.calculationStrike(computer,user);
        assertThat(strike).isEqualTo(1);

    }
    @Test
    @DisplayName("2 스트라이크 경우 ")
    public void twoStrikeScenario() throws Exception{
        List<Integer> computer  = List.of(4,5,7);
        List<Integer> user = List.of(4,5,6);

        int strike = Application.calculationStrike(computer,user);
        assertThat(strike).isEqualTo(2);

    }
    @Test
    @DisplayName("3 스트라이크 경우 ")
    public void threeStrikeScenario() throws Exception{
        List<Integer> computer  = List.of(4,5,6);
        List<Integer> user = List.of(4,5,6);

        int strike = Application.calculationStrike(computer,user);
        assertThat(strike).isEqualTo(3);

    }

    @Test
    @DisplayName("낫싱")
    public void nothing() throws Exception{
        String result = Application.printCurrentSituation(0,0);
        assertThat(result).isEqualTo("낫싱");

    }


    @Test
    @DisplayName("볼만 있는 경우")
    public void ballOnly() throws Exception{
        String result = Application.printCurrentSituation(2,0);
        assertThat(result).isEqualTo("2볼");

    }
    @Test
    @DisplayName("스트라이크만 있는 경우")
    public void strikeOnly() throws Exception{
        String result = Application.printCurrentSituation(0,3);
        assertThat(result).isEqualTo("3스트라이크");

    }









}
