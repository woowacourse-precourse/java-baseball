package baseball.validator;

import baseball.utils.validators.UserInputValidator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserInputExceptionTest {

    @Test
    void caseUserGameInputNotNumber(){
        String input = "abc";

        userGameInputTest(input);
    }

    @Test
    void caseUserGameInputLengthOver(){
        String input = "1234";

        userGameInputTest(input);
    }

    @Test
    void caseUserGameInputHasDuplicated(){
        String input = "113";

        userGameInputTest(input);
    }

    void userGameInputTest(String input){
        assertThatThrownBy(() ->
                UserInputValidator.validateRetryInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void caseRetryInputLengthOver(){
        String retry = "12";

        retryExceptionTest(retry);
    }

    @Test
    void caseRetryInputNotNumber(){
        String retry = "a";

        retryExceptionTest(retry);
    }

    @Test
    void caseRetryInputNoCorrectValue(){
        String retry = "3";

        retryExceptionTest(retry);
    }

    @Test
    void caseWrongRetryInput(){
        String retry = "3ad";

        retryExceptionTest(retry);
    }

    void retryExceptionTest(String retry){
        assertThatThrownBy(() ->
                UserInputValidator.validateRetryInput(retry))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
