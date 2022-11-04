package baseball;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RoundTest extends NsTest {
    @Test
    void start_test_round_start() {
        run("467", "135", "235");
        assertThat(output()).contains("낫싱", "2스트라이크", "3스트라이크");
    }

    @Test
    void generateNewHiddenNumberList_test_list_generation() {
        Round round = new Round();
        List<Integer> result = round.generateNewHiddenNumberList();
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    void addNewHiddenNumberToList_test_new_number_generation() {
        Round round = new Round();

        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9));
        round.addNewHiddenNumberToList(input);

        assertThat(input).contains(4);
    }

    @Override
    public void runMain() {
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);
        new Round(testHiddenNumberList).start();
    }
}
