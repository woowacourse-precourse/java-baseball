package baseball.user;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("컴퓨터(상대방) 테스트")
class OpponentTest {

    @Test
    @DisplayName("난수 범위 체크")
    void 컴퓨터_범위_체크(){
        for(int i= 0; i < 1000; i++){
            Opponent o = new Opponent();
            assertThat(o.getNumber()).isBetween(100, 999);
        }
    }
    @Test
    @DisplayName("난수 자릿수 체크")
    void 컴퓨터_중복_체크(){
        Opponent o = new Opponent();
        List<Integer> list = new ArrayList<>();
        int num = o.getNumber();
        for(int i = 0; i < Opponent.SIZE; i++){
            Integer remainder = num % 10;
            assertThat(list.contains(remainder)).isEqualTo(false);
            list.add(remainder);
            num /= 10;
        }
    }


}
