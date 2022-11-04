package function;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Application.*;
import static org.assertj.core.api.Assertions.*;

public class FunctionTest {

    @Test
    public void 정답_리스트_사이즈_확인() throws Exception {
        //given

        //when
        List<Integer> baseballList = createBaseballNumberList();
        Set<Integer> distinct = new HashSet<>(baseballList);

        // then
        assertThat(baseballList.size()).isEqualTo(3);
        assertThat(distinct.size()).isEqualTo(3);

    }
}
