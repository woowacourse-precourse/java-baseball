package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.spy;

public class MyTest extends NsTest {

    @Test
    void 컴퓨터가_다른_3가지수_선택() {
        List<Integer> spyList = spy(Application.class).setComputer();

        assertThat(spyList.size()).as("out of range").isEqualTo(3);
    }

    @Test
    void 사용자가_입력한_값이_예외인가() {
        List<Integer> userList = Arrays.asList(2, 2, 3);

        assertThatThrownBy( () -> spy(Application.class).checkUserHasException(userList) )
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}
