package baseball;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyFunctionTest {

    @Test
    void Random_수_리스트가_잘_구성돼있는지_확인() {
        int index = 3;
        List<Integer> oneToNine = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        assertThat(Application.getRandomNumber().size()).isEqualTo(index);
        for(int i = 0; i < 3; i++) {
            assertThat(oneToNine).contains(Application.getRandomNumber().get(i));
        }
    }
}
