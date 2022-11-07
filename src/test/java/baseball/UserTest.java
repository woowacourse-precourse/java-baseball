package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class UserTest {

    @Test
    void generateNumberTest(){
        assertThat(Application.generateNumber().size() == 3);
    }

    @Test
    void checkInputTest(){
        assertThatThrownBy(() -> Application.checkInput("1234"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.checkInput("aaa"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.checkInput("111"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void countAnswerTest(){
        List<Integer> answer = List.of(1, 2, 3);
        List<Integer> test1 = List.of(1, 2, 3);
        List<Integer> count1 = List.of(0, 3);
        List<Integer> test2 = List.of(2, 1, 3);
        List<Integer> count2 = List.of(2, 1);
        assertThat(Application.countAnswer(answer, test1)).isEqualTo(count1);
        assertThat(Application.countAnswer(answer, test2)).isEqualTo(count2);
    }
}
