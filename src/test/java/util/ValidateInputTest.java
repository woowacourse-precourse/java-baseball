package util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidateInputTest {

    @Test
    void validate_String을_List로_변경() {
        String input = "123";
        List<Integer> inputList = new ArrayList<>();
        inputList.add(1);
        inputList.add(2);
        inputList.add(3);

        List<Integer> result = new ArrayList<>();
        result.add(input.charAt(0) - '0');
        result.add(input.charAt(1) - '0');
        result.add(input.charAt(2) - '0');
        assertThat(result).isEqualTo(inputList);

    }

    @Test
    void validate_숫자로_이루어져_있는지_확인() {
        String input = "123";
        Double number = (double) 123;
        Double result = Double.parseDouble(input);
        assertThat(result).isEqualTo(number);

    }

}
