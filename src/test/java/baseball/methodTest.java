package study;

import java.util.List;

import baseball.Application;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class methodTest {

    @Test
    void checkRandomNumberTest() {
        List<Integer> numbers = Application.createThreeDigitsRandomNumber();
        for(int i=0;i<numbers.size();i++){
            System.out.print(numbers.get(i)+" ");
        }
    }

    @Test
    void countBallStrikeTest1() {
        List<Integer> computer = List.of(1,2,3);
        List<Integer> user = List.of(1,2,3);
        String result = "3스트라이크";
        assertThat(Application.countBallStrike(computer, user)).isEqualTo(result);
    }

    @Test
    void countBallStrikeTest2() {
        List<Integer> computer = List.of(1,2,3);
        List<Integer> user = List.of(1,3,4);
        String result = "1볼 1스트라이크";
        assertThat(Application.countBallStrike(computer, user)).isEqualTo(result);
    }

    @Test
    void countBallStrikeTest3() {
        List<Integer> computer = List.of(1,2,3);
        List<Integer> user = List.of(4,5,6);
        String result = "낫싱";
        assertThat(Application.countBallStrike(computer, user)).isEqualTo(result);
    }

    @Test
    void userInputTest1() {
        assertThat(Application.checkNumberIsValid("123")).isEqualTo(true);
    }

    @Test
    void userInputTest2() {
        assertThatThrownBy(() -> Application.checkNumberIsValid("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void userInputTest3() {
        assertThatThrownBy(() -> Application.checkNumberIsValid("012"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void changeStringToListTest() {
        assertThat(Application.changeStringToList("123")).isEqualTo(List.of(1,2,3));
    }

}
