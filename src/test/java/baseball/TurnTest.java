package baseball;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;

public class TurnTest extends NsTest {
    @Test
    @DisplayName("새로운 턴 시작 테스트")
    void start_test(){
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);

        Turn turn = new Turn();

        String testInput = "534";
        final byte[] buf = testInput.getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        turn.start(testHiddenNumberList);

        String resultOutput = "숫자를 입력해주세요 : 1볼 1스트라이크";
        assertThat(output()).isEqualTo(resultOutput);
    }

    @Test
    @DisplayName("사용자 입력 테스트")
    void getPlayerInput_test_getting_input() {
        Turn turn = new Turn();
        String testInput = "234";
        final byte[] buf = testInput.getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        assertThat(turn.getPlayerInput("숫자를 입력해주세요 : ")).isEqualTo(testInput);
    }

    @Test
    @DisplayName("사용자 입력 문자열을 리스트로 변환 테스트")
    void transformPlayerInputToList_test_transforming_input_string_to_list() {
        Turn turn = new Turn();
        String testInput = "123";
        List<Integer> resultOutput = List.of(1, 2, 3);
        assertThat(turn.transformPlayerInputToList(testInput)).isEqualTo(resultOutput);
    }

    @Test
    @DisplayName("문자를 정수로 변환 테스트")
    void transformCharacterToInteger_test_transforming_character_to_integer() {
        Turn turn = new Turn();
        char character = '3';
        int resultOutput = 3;
        assertThat(turn.transformCharacterToInteger(character)).isEqualTo(resultOutput);
    }

    @Test
    @DisplayName("사용자 입력 숫자 개수가 3보다 큰 경우 예외 처리 테스트")
    void validatePlayerNumberList_test_input_length_larger_than_3() {
        Turn turn = new Turn();
        List<Integer> testInput = List.of(1, 2, 3, 4);
        assertThatThrownBy(() -> turn.validatePlayerNumberList(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3개의 숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("사용자 입력 숫자 개수가 3보다 작은 경우 예외 처리 테스트")
    void validatePlayerNumberList_test_input_length_smaller_than_3() {
        Turn turn = new Turn();
        List<Integer> testInput = List.of(1, 2);
        assertThatThrownBy(() -> turn.validatePlayerNumberList(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3개의 숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("사용자 입력이 1-9사이의 숫자가 아닌 경우 예외 처리 테스트")
    void validatePlayerNumberList_test_input_including_non_number_character() {
        Turn turn = new Turn();
        List<Integer> testInput = List.of(33, 42, 55);
        assertThatThrownBy(() -> turn.validatePlayerNumberList(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1에서 9까지의 숫자를 입력해 주세요.");
    }

    @Test
    @DisplayName("사용자 입력에 같은 숫자가 포함된 경우 예외 처리 테스트")
    void validatePlayerNumberList_test_input_including_redundant_numbers() {
        Turn turn = new Turn();
        List<Integer> testInput = List.of(1, 1, 2);
        assertThatThrownBy(() -> turn.validatePlayerNumberList(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("서로 다른 숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("사용자 입력이 없는 경우 예외 처리 테스트")
    void validatePlayerNumberList_test_input_empty() {
        Turn turn = new Turn();
        List<Integer> testInput = List.of();
        assertThatThrownBy(() -> turn.validatePlayerNumberList(testInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("3개의 숫자를 입력해주세요.");
    }

    @Test
    @DisplayName("2볼인 경우 개수 계산 테스트")
    void countNumberOfBalls_test_ball_count() {
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);
        List<Integer> testPlayerNumberList = List.of(3, 4, 2);
        Turn turn = new Turn();
        assertThat(turn.countNumberOfBalls(testPlayerNumberList, testHiddenNumberList))
                .isEqualTo(2);
    }

    @Test
    @DisplayName("2스트라이크인 경우 개수 계산 테스트")
    void countNumberOfStrikes_test_strike_count() {
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);
        List<Integer> testPlayerNumberList = List.of(2, 4, 5);
        Turn turn = new Turn();
        assertThat(turn.countNumberOfStrikes(testPlayerNumberList, testHiddenNumberList))
                .isEqualTo(2);
    }

    @Test
    @DisplayName("1볼 2스트라이크인 경우 결과 출력 테스트")
    void printResult_test_print_result_1ball_1strike() {
        Turn turn = new Turn();
        turn.printResult(1, 1);

        String resultOutput = "1볼 1스트라이크";
        assertThat(output()).isEqualTo(resultOutput);
    }

    @Test
    @DisplayName("0볼 3스트라이크인 경우 결과 출력 테스트")
    void printResult_test_print_result_0ball_3strike() {
        Turn turn = new Turn();
        turn.printResult(0, 3);

        String resultOutput = "3스트라이크";
        assertThat(output()).isEqualTo(resultOutput);
    }

    @Test
    @DisplayName("3볼 0스트라이크인 경우 결과 출력 테스트")
    void printResult_test_print_result_3ball() {
        Turn turn = new Turn();
        turn.printResult(3, 0);

        String resultOutput = "3볼";
        assertThat(output()).isEqualTo(resultOutput);
    }

    @Test
    @DisplayName("0볼 0스트라이크인 경우 결과 출력 테스트")
    void printResult_test_print_result_nothing() {
        Turn turn = new Turn();
        turn.printResult(0, 0);

        String resultOutput = "낫싱";
        assertThat(output()).isEqualTo(resultOutput);
    }

    @Test
    @DisplayName("1볼인 경우 출력 메시지 반환 테스트")
    void getBallResultString_test_ball_result() {
        Turn turn = new Turn();

        String resultOutput = "1볼";

        assertThat(turn.getBallResultString(1)).isEqualTo(resultOutput);
    }

    @Test
    @DisplayName("2스트라이크인 경우 출력 메시지 반환 테스트")
    void getStrikeResultString_test_strike_result() {
        Turn turn = new Turn();

        String resultOutput = "2스트라이크";

        assertThat(turn.getStrikeResultString(2)).isEqualTo(resultOutput);
    }

    @Test
    @DisplayName("3스트라이크인 경우 게임 종료 확인 테스트")
    void isStrikeOut_test_strike_3() {
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);

        Turn turn = new Turn();

        String testInput = "235";
        final byte[] buf = testInput.getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        turn.start(testHiddenNumberList);

        assertThat(turn.isStrikeOut()).isEqualTo(true);
    }

    @Test
    @DisplayName("1스트라이크인 경우 게임 미종료 확인 테스트")
    void isStrikeOut_test_strike_1() {
        List<Integer> testHiddenNumberList = List.of(2, 3, 5);

        Turn turn = new Turn();

        String testInput = "264";
        final byte[] buf = testInput.getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        turn.start(testHiddenNumberList);

        assertThat(turn.isStrikeOut()).isEqualTo(false);
    }

    @Test
    @DisplayName("게임 종료 메시지 출력 테스트")
    void printGameOverMessage_test_print_message() {
        Turn turn = new Turn();
        turn.printGameOverMessage();
        assertThat(output()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void runMain() {}
}
