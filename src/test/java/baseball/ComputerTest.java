package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest extends NsTest {
    @Test
    @DisplayName("정상 값")
    void getInput() {
        //given
        //when
        Computer opponent = new Computer();

        //then
        System.out.println(opponent.getComputer());
    }

    @Test
    void checkForApplicationTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    Computer opponent = new Computer();
                    System.out.println(opponent.getComputer());
                    assertThat(output()).contains("[1, 3, 5]");
                },
                1, 3, 5
        );
    }


    @Override
    protected void runMain() {

    }
}