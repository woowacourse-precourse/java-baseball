package baseball.exception;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class InputExceptionTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "1", "23", "1234", "132983", "4837483294", "94823984104892", "19824390284091829408129048", "32873873737"})
    void expectedNumberOfUser_값의_길이가_3이_아닐때의_유효성_검증(String expectedNumberOfUser) {

        assertThatThrownBy(() -> InputException.isExpectedNumberOfUserValid(expectedNumberOfUser))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"112", "122", "323", "555", "131"})
    void expectedNumberOfUser_값에_동일한_숫자가_포함됐을때의_유효성_검증(String expectedNumberOfUser) {

        assertThatThrownBy(() -> InputException.isExpectedNumberOfUserValid(expectedNumberOfUser))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"110", "102", "020", "000", "001"})
    void expectedNumberOfUser_값에_0이_포함됐을때의_유효성_검증(String expectedNumberOfUser) {

        assertThatThrownBy(() -> InputException.isExpectedNumberOfUserValid(expectedNumberOfUser))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"11`", "w22", "!&3", "-23@=2", "weoqkwpoek", "*(@$huqw*@$7jh", "123``2#I@(k2332@3ujai"})
    void expectedNumberOfUser_값에_숫자가_아닌_값이_들어왔을때의_유효성_검증(String expectedNumberOfUser) {

        assertThatThrownBy(() -> InputException.isExpectedNumberOfUserValid(expectedNumberOfUser))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "3", "4", "1231", "12", "weq09ue2", "@83j%Wije"})
    void valueOfRestartGameOrNotValid_값에_1이나_2가_아닌_값이_들어왔을때의_유효성_검증(String valueOfRestartGameOrNotValid) {

        assertThatThrownBy(() -> InputException.isValueOfRestartGameOrNotValid(valueOfRestartGameOrNotValid))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
