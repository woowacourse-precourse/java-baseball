package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 숫자비교_3스트라이크인지_확인1(){
        boolean[] isBall = new boolean[10];
        Arrays.fill(isBall, false);
        String computer="123";
        Application.setIsBall(isBall, computer);
        String player="123";
        boolean result = true;

        boolean output = Application.compareNumbers(isBall, computer, player);
        assertThat(output).isEqualTo(result);
    }
    @Test
    void 숫자비교_3스트라이크인지_확인2(){
        boolean[] isBall = new boolean[10];
        Arrays.fill(isBall, false);
        String computer="723";
        Application.setIsBall(isBall, computer);
        String player="123";
        boolean result = false;

        boolean output = Application.compareNumbers(isBall, computer, player);
        assertThat(output).isEqualTo(result);
    }
    @Test
    void 숫자비교_3스트라이크인지_확인3(){
        boolean[] isBall = new boolean[10];
        Arrays.fill(isBall, false);
        String computer="678";
        Application.setIsBall(isBall, computer);
        String player="123";
        boolean result = false;

        boolean output = Application.compareNumbers(isBall, computer, player);
        assertThat(output).isEqualTo(result);
    }

    @Test
    void 메시지_만들기1(){
        int ballCount = 0;
        int strike = 0;
        String message = Application.makeCountMessage(ballCount, strike);
        String result = "낫싱";
        assertThat(message).isEqualTo(result);
    }
    @Test
    void 메시지_만들기2(){
        int ballCount = 1;
        int strike = 0;
        String message = Application.makeCountMessage(ballCount, strike);
        String result = "1볼";
        assertThat(message).isEqualTo(result);
    }
    @Test
    void 메시지_만들기3(){
        int ballCount = 0;
        int strike = 1;
        String message = Application.makeCountMessage(ballCount, strike);
        String result = "1스트라이크";
        assertThat(message).isEqualTo(result);
    }
    @Test
    void 메시지_만들기4(){
        int ballCount = 2;
        int strike = 1;
        String message = Application.makeCountMessage(ballCount, strike);
        String result = "2볼 1스트라이크";
        assertThat(message).isEqualTo(result);
    }

    @Test
    void 플레이어_숫자_검증1() {
        String number = "123";
        boolean check = Application.checkPlayerNumber(number);
        boolean result = true;
        assertThat(check).isEqualTo(result);
    }
    @Test
    void 플레이어_숫자_검증2() {
        String number = "102";
        boolean check = Application.checkPlayerNumber(number);
        boolean result = false;
        assertThat(check).isEqualTo(result);
    }
    @Test
    void 플레이어_숫자_검증3() {
        String number = "112";
        boolean check = Application.checkPlayerNumber(number);
        boolean result = false;
        assertThat(check).isEqualTo(result);
    }
    @Test
    void 플레이어_숫자_검증4() {
        String number = "3412";
        boolean check = Application.checkPlayerNumber(number);
        boolean result = false;
        assertThat(check).isEqualTo(result);
    }
    @Test
    void 플레이어_숫자_검증5() {
        String number = "";
        boolean check = Application.checkPlayerNumber(number);
        boolean result = false;
        assertThat(check).isEqualTo(result);
    }

    @Test
    void 숫자리스트_문자열로_변환메소드() {
        List<Integer> number = Arrays.asList(1, 2, 3);
        String newNumber = Application.toStringComputerNumber(number);
        String result = "123";
        assertThat(newNumber).isEqualTo(result);
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
        Application.main(new String[]{});
    }
}
