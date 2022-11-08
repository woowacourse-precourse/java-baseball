package baseball;

import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundTest extends NsTest {
    @Test
    @DisplayName("새로운 라운드 시작 테스트")
    void start_test_round_start() {
        run("467", "135", "235");
        assertThat(output()).contains("낫싱", "2스트라이크", "3스트라이크", "3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Test
    @DisplayName("새로운 숫자야구 숫자 리스트 생성 테스트")
    void generateNewHiddenNumberList_test_list_generation() {
        Round round = new Round();
        List<Integer> result = round.generateNewHiddenNumberList();
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("리스트에 존재하는 숫자들과 겹치지 않는 새로운 무작위 숫자 생성 테스트")
    void addNewRandomToList_test_new_number_generation() {
        Round round = new Round();

        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9));
        round.addNewRandomNumberToList(input);

        assertThat(input).contains(4);
    }

    @Override
    public void runMain() {
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);
        new Round(testHiddenNumberList).start();
    }
}
