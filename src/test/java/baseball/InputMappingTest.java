package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputMappingTest extends NsTest {
    InputMapping inputMapping;

    public InputMappingTest() {
        this.inputMapping = new InputMapping();
    }

    @Test
    void getRestartFlagCase1() {
        systemIn("1\n");
        assertThat(inputMapping.getRestartFlag()).isEqualTo(1);
    }

    @Test
    void getRestartFlagCase2() {
        systemIn("3\n");

        assertThatThrownBy(inputMapping::getRestartFlag)
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void getGameNumberListCase1(){
        systemIn("123\n");

        List<Integer> answer = new ArrayList<>();
        answer.add(3);
        answer.add(2);
        answer.add(1);

        assertThat(this.inputMapping.getGameNumberList()).isEqualTo(answer);
    }

    @Test
    void getGameNumberListCase2(){
        systemIn("223\n");

        List<Integer> answer = new ArrayList<>();
        answer.add(3);
        answer.add(2);
        answer.add(2);

        assertThat(this.inputMapping.getGameNumberList()).isEqualTo(answer);
    }

    @Test
    void getGameNumberListCase3(){
        systemIn("53\n");

        assertThatThrownBy(this.inputMapping::getGameNumberList)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getGameNumberListCase4(){
        systemIn("130\n");

        assertThatThrownBy(this.inputMapping::getGameNumberList)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{
                }
        );
    }

    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}