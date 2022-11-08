package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class ExceptionTest {

    @Test
    void check_three_digit_number_user_input() {
        List<Integer> testInput = List.of(1, 2, 5, 6);
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Exception.checkInputNumbers(testInput))
        );
    }

    @Test
    void check_one_digit_number_user_input_and_charDetect() {
        String testInputTwoDigit = "12";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Exception.checkInputNumber(testInputTwoDigit))
        );
    }

    @Test
    void check_one_digit_number() {
        String testInput = "12";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Exception.checkInputNumber(testInput))
        );
    }

    @Test
    void check_one_digit_number_given_notnumber() {
        String testInput = "%";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Exception.checkInputNumber(testInput))
        );
    }

    @Test
    void check_case_of_not_number() {
        String testInput = "%";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Exception.checkCharDetect(testInput))
        );
    }

    @Test
    void check_nummber_length_over_three() {
        List<Integer> testInput = List.of(1, 2, 5, 6);
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Exception.checkNumbersLength(testInput))
        );
    }

    @Test
    void check_nummber_length_under_three() {
        List<Integer> testInput = List.of(1, 2);
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Exception.checkNumbersLength(testInput))
        );
    }

    @Test
    void check_numbers_given_same_number() {
        List<Integer> testInput = List.of(1, 1, 5);
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Exception.checkDuplicated(testInput))
        );
    }

    @Test
    void check_numbers_contain_0() {
        List<Integer> testInput = List.of(1, 0, 5);
        assertSimpleTest(() ->
                assertThatThrownBy(() -> Exception.checkInputNumbers(testInput))
        );
    }
}