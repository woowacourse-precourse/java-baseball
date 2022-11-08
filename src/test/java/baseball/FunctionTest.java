package baseball;

import org.junit.jupiter.api.Test;
import java.util.*;
import static baseball.Function.*;
import static org.assertj.core.api.Assertions.*;

public class FunctionTest {

    Computer computer = new Computer();
    Player player = new Player();
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
    void checkTrue_boolean으로_이루어진_리스트가_true값을_가지는지_판별(){
        List<Boolean> list_1 = List.of(true,false);
        boolean result_1 = checkTrue(list_1);
        List<Boolean> list_2 = List.of(false,false);
        boolean result_2 = checkTrue(list_2);
        assertThat(result_1).isEqualTo(true);
        assertThat(result_2).isEqualTo(false);
    }
}
