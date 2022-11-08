package baseball;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ImplementTest extends NsTest{

    @Test
    void 정답_생성_테스트() {
        List<Integer> answer = GameManager.createAnswer();
        assertThat(answer.size()).isEqualTo(3);
        for(int element : answer) {
            assertThat(element)
                .isGreaterThan(0)
                .isLessThan(10);
        }
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
