package baseball;

import org.junit.jupiter.api.Test;
import java.util.*;
import static baseball.Computer.*;
import static baseball.Player.*;
import static org.assertj.core.api.Assertions.*;

public class FunctionTest {
    @Test
    void addRandomNumber_리스트에_1부터_9까지의_랜덤정수_추가() {
        boolean result = false;
        List<Integer> list = new ArrayList<>();
        addRandomNumber(list);
        Set<Integer> set = new HashSet<>(list);
        if(list.size() == set.size()){
            result = true;
        }
        for (int i = 0; i< list.size(); i++){
            int num = list.get(i);
            if(num<=9 && num>=1){
                result = true;
            }
        }
        assertThat(result).isEqualTo(true);
    }

    @Test
    void makeAnswer_컴퓨터_정답_만들기(){
        List<Integer> answer = makeAnswer();
        int result = answer.size();
        assertThat(result).isEqualTo(3);
    }

    @Test
    void isInteger_입력받은_문자열이_정수로_이루어졌는지_판별(){
        boolean result = isInteger("1.3f");
        assertThat(result).isEqualTo(false);
    }

    @Test
    void isPositiveNumber_입력받은_문자열이_자연수인지_판별(){
        boolean result = isPositiveNumber("-123");
        assertThat(result).isEqualTo(false);
    }

    @Test
    void changeStringtoList_문자열을_리스트로_변환(){
        List<Integer> result = changeStringtoList("1234");
        assertThat(result).isEqualTo(List.of(1, 2, 3,4));
    }

    @Test
    void isDifferentNumbers_서로_다른_정수로_이루어진_리스트인지_판별(){
        List<Integer> list = List.of(1,2,4,4);
        boolean result = isDifferentNumbers(list);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void isValidAnswer_메서드_사용시_입력받은_문자열이_조건을_만족하지_못할시_예외_발생() {
        String input = "1234";

        assertThatThrownBy(() -> isValidAnswer(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("게임종료");
    }

    @Test
    void guessAnswer_정답_예측_메소드(){
        Player player = new Player();
        String input = "123";
        try {
            isValidAnswer(input);
            player.Answer = changeStringtoList(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        assertThat(player.Answer).isEqualTo(List.of(1,2,3));
    }
}
