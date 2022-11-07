package baseball.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InputParametersTest {
    @ParameterizedTest
    @ValueSource(strings = {"78 ","  "})
    void if_contain_blank(String string){
        assertThrows(IllegalArgumentException.class, ()-> new InputParameters(string));
    }
}