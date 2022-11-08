package baseball;

import org.junit.jupiter.api.Test;
import java.util.List;
import static baseball.Opponent.*;
import static org.assertj.core.api.Assertions.*;

public class OpponentTest {

    @Test
    void checkRandomNumber_메서드로_중복값일_경우_false_반환(){
        int num = 1;
        List<Integer> list = List.of(1,2);
        boolean result = checkRandomNumber(num, list);
        assertThat(result).isEqualTo(false);
    }

    @Test
    void checkRandomNumber_메서드로_중복값이_아닐_경우_true_반환(){
        int num = 3;
        List<Integer> list = List.of(1,2);
        boolean result = checkRandomNumber(num, list);
        assertThat(result).isEqualTo(true);
    }

    @Test
    void createAnswer_메서드로_3자리수_정답_생성_확인(){
        List<Integer> list = createAnswer();
        int length = list.size();
        assertThat(length).isEqualTo(3);
    }

    @Test
    void getNumber_메서드로_정답수_한개씩_반환(){
        List<Integer> list =  List.of(1,2,3);
        int index = 1;
        int result = getNumber(list, index);
        assertThat(result).isEqualTo(2);
    }
}
