package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class DefenceNumberTest {

    private static final int SIZE = 3;

    @Test
    void 중복되지_않는지_확인() {
        DefenceNumber defenceNumber = new DefenceNumber(3);
        List<Integer> defenceNumberList = defenceNumber.getDefenceNumber();

        Set<Integer> result = new HashSet<>(defenceNumberList);

        assertThat(result.size()).isEqualTo(SIZE);
    }

    @Test
    void 주어진_크기와_일치하는지_확인() {
        DefenceNumber defenceNumber = new DefenceNumber(3);
        List<Integer> defenceNumberList = defenceNumber.getDefenceNumber();

        assertThat(defenceNumberList.size()).isEqualTo(SIZE);
    }
}
