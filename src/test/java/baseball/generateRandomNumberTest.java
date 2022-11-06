package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class generateRandomNumberTest {

    @Test
    void 항상_3자리_랜덤숫자가_나오는지_테스트() {
        //given

        //when
        for(int i = 0; i < 100; i++) {
            List<Integer> actual = generateRandomNumber();
            //then
            int size = actual.stream().distinct().collect(Collectors.toList()).size();
            assertThat(actual)
                    .isNotEmpty()
                    .hasSize(3)
                    .doesNotContain(0);
            assertThat(size)
                    .isEqualTo(3);
        }

    }

    List<Integer> generateRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }
}
