package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.spy;

public class MyTest extends NsTest {

    @Test
    void 컴퓨터가_다른_3가지수_선택() {
        List<Integer> spyList = spy(Application.class).setComputer();

        assertThat(spyList.size()).as("out of range").isEqualTo(3);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }


}
