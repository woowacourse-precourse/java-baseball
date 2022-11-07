package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MakeRandomNumbersTest extends NsTest{
    String number = baseball.Application.makeRandomNumbers();
    @Test
    void check_answer_is_three_numbers(){
        assertThat(number.length()).isEqualTo(3);
    }
    @Test
    void check_answer_has_three_different_numbers(){
        for(int i=0;i<3;i++){
            int inumber = Integer.parseInt(String.valueOf(number.charAt(i)));
            System.out.println("test");
            System.out.println(inumber);
            assertTrue(inumber > 0 && inumber < 10);
        }
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
class PlayballTest extends NsTest{
    @Test
    void check_playball_function(){
        ArrayList<String> answer = new ArrayList<>();
        answer.add("1");
        answer.add("2");
        answer.add("3");
        ArrayList<String> input = new ArrayList<>();
        input.add("3");
        input.add("4");
        input.add("1");
        assertThat(baseball.Application.playBall(answer, input)).isEqualTo("2볼");
    }

    @Test
    void check_playball_function2(){
        ArrayList<String> answer = new ArrayList<>();
        answer.add("8");
        answer.add("3");
        answer.add("4");
        ArrayList<String> input = new ArrayList<>();
        input.add("8");
        input.add("0");
        input.add("4");
        assertThat(baseball.Application.playBall(answer, input)).isEqualTo("2스트라이크");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
class ApplicationTest extends NsTest {
    @Test
    void GameRestart() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void ExceptionTesting() {
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
