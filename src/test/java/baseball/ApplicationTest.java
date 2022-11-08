package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static baseball.Application.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @Test
    void 상대방_사용자_결과값_판단(){
        selectNumber();

        List<Integer> numbers1 = new ArrayList<>();
        numbers1.add(3);
        numbers1.add(5);
        numbers1.add(2);
        checkNumber(numbers1);

        assertThat(outputResult().isEmpty()).isFalse();
    }

    @Test
    void 상대방_숫자_개수_확인(){
        selectNumber();
        assertThat(computer.size()).isEqualTo(3);
    }
    
    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        try {
            Application.main(new String[]{});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
