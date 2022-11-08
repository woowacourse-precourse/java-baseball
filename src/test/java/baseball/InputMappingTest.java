package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputMappingTest extends NsTest {

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    void getConsoleIntCase1() {
        systemIn("123\n");

        InputMapping inputMapping = new InputMapping();

        assertThat(inputMapping.getConsoleInt()).isEqualTo(123);
    }

    @Test
    void getConsoleIntCase2() {
        systemIn("1an34\n");

        InputMapping inputMapping = new InputMapping();

        assertThatThrownBy(inputMapping::getConsoleInt)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getConsoleIntCase3() {
        systemIn("2147483648\n"); // out of Int

        InputMapping inputMapping = new InputMapping();

        assertThatThrownBy(inputMapping::getConsoleInt)
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Override
    public void runMain() {
        Application.main(new String[]{
                }
        );
    }
}