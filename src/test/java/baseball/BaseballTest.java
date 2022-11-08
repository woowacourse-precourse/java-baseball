package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballTest {
    private Hint hint;
    private List<Integer> answer = new ArrayList<>(Arrays.asList(1, 2, 3));

    void 힌트_테스트(String userInput, String message){
        hint = new Hint();
        List<Integer> userAnswer = Validator.convertor(userInput);
        assertThat(hint.compareNumber(answer, userAnswer)).contains(message);
    }

    @Test
    void 정답_테스트() {
        String userInput = "123";
        힌트_테스트(userInput, "게임 종료");
    }

    @Test
    void 볼_테스트() {
        String userInput2 = "234";
        힌트_테스트(userInput2, "2볼 ");

        userInput2 = "541";
        힌트_테스트(userInput2, "1볼 ");

        userInput2 = "312";
        힌트_테스트(userInput2, "3볼 ");
    }

    @Test
    void 스트라이크_테스트() {
        String userInput = "145";
        힌트_테스트(userInput, "1스트라이크");

        userInput = "125";
        힌트_테스트(userInput, "2스트라이크");

        userInput = "123";
        힌트_테스트(userInput, "3스트라이크");
    }

    @Test
    void 볼_스트라이크_테스트() {
        String userInput = "132";
        힌트_테스트(userInput, "2볼 1스트라이크");
    }


    void 예외_테스트(String userInput) {
        assertThatThrownBy(() -> Validator.convertor(userInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 길이_예외_테스트(){
        String userInput = "1234";
        예외_테스트(userInput);

    }

    @Test
    void 범위_예외_테스트(){
        String userInput = "012";
        예외_테스트(userInput);
    }

    @Test
    void 숫자_예외_테스트(){
        String userInput = "a12";
        예외_테스트(userInput);
    }
}
