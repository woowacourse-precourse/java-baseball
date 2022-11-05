package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MethodUnitTest {
    @DisplayName("랜덤 수 세자리 숫자여부")
    @Test
    void makeRandomNum_세자리_숫자여부(){
        int result = Application.makeRandomNum();

        assertThat(result).isGreaterThan(111);
        assertThat(result).isLessThan(999);
    }

    @DisplayName("랜덤 수 각 자리 숫자 다른지")
    @Test
    void makeRandomNum_각_자리_숫자_다른지(){
        int num = Application.makeRandomNum();
        int first = num/100;
        int second = num/10-first*10;
        int third = num%10;

        assertThat(first).isNotEqualTo(second);
        assertThat(first).isNotEqualTo(third);
        assertThat(second).isNotEqualTo(third);
    }

    @DisplayName("스트라이크 작동 테스트")
    @Test
    void strike_작동_테스트(){
        int noStrike = Application.strike(123, 341);
        int oneStrike = Application.strike(123, 625);
        int twoStrike = Application.strike(123, 423);
        int threeStrike = Application.strike(123,123);

        assertThat(noStrike).isEqualTo(0);
        assertThat(oneStrike).isEqualTo(1);
        assertThat(twoStrike).isEqualTo(2);
        assertThat(threeStrike).isEqualTo(3);
    }
}
