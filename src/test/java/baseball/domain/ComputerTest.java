package baseball.domain;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ComputerTest {

    @Test
    void 컴퓨터_숫자_생성_개수확인() {
        List<Integer> list = Computer.createNumbers();
        assertThat(list).hasSize(3);
    }

}
