package baseball;

import java.util.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import baseball.utility.Utility;

public class UtilityTest {
    @Test
    void 랜덤숫자생성확인(){
        Utility u = new Utility();
        String res = u.makeThreeRandomNumber();
        Set<String> set = new HashSet<>();
        for(int i=0; i<res.length(); i++){
            set.add(res.substring(i, i+1));
        }
        assertThat(set.size()).isEqualTo(3);
    }

    @Test
    void 볼스트라이크_계산확인1(){
        Utility u = new Utility();
        String user = "543";
        String answer = "542";
        List<Integer> list = u.CalculateBallAndStrike(user, answer);
        List<Integer> result = List.of(2, 0);
        assertThat(list).isEqualTo(result);
    }

    @Test
    void 볼스트라이크_계산확인2(){
        Utility u = new Utility();
        String user = "567";
        String answer = "342";
        List<Integer> list = u.CalculateBallAndStrike(user, answer);
        List<Integer> result = List.of(0, 0);
        assertThat(list).isEqualTo(result);
    }

    @Test
    void 볼스트라이크_계산확인3(){
        Utility u = new Utility();
        String user = "147";
        String answer = "714";
        List<Integer> list = u.CalculateBallAndStrike(user, answer);
        List<Integer> result = List.of(0, 3);
        assertThat(list).isEqualTo(result);
    }
}
