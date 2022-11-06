package study;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Randoms API 학습 테스트")
public class RandomsTest {
    @Test
    @DisplayName("start이상 end이하의 수 하나를 랜덤으로 뽑는다.")
    void pickNumberInRange_범위_확인(){
        // given
        int start = 1;
        int end = 9;

        // when
        int num = Randoms.pickNumberInRange(start, end);

        // then
        assertThat(num).isGreaterThanOrEqualTo(start)
                .isLessThanOrEqualTo(end);
    }
}
