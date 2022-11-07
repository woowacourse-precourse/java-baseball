package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;


public class FeatureTest {

    @Test
    @DisplayName("다른 숫자 3개가 들어온 경우에만 예외를 발생하지 않는다.")
    void 사용자_입력_테스트() {
        assertThrows(IllegalArgumentException.class,
                () -> Application.getUserAnswerList("122"));
        ;

        assertThrows(IllegalArgumentException.class,
                () -> Application.getUserAnswerList("1234"));
        ;

        assertThrows(IllegalArgumentException.class,
                () -> Application.getUserAnswerList("1d2"));
        ;

        assertThrows(IllegalArgumentException.class,
                () -> Application.getUserAnswerList("012"));
        ;

        assertEquals(Application.getUserAnswerList("123"), List.of(1,2,3));
    }

    @Test
    @DisplayName("서로 다른 숫자 3개를 반환해야 한다.")
    void 랜덤_숫자_초기화_테스트() {
        // when
        List<Integer> randomNumber = Application.getRandomNumber();

        // then
        assertThat(randomNumber.size()).isEqualTo(3);
        assertThat(randomNumber.stream().distinct().count()).isEqualTo(3);

        for (Integer num : randomNumber) {
            assertThat(num).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(9);
        }
    }
}
