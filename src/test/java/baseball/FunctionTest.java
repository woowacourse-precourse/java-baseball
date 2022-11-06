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
}
