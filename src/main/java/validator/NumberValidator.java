package validator;

import java.util.ArrayList;
import java.util.List;

import static constant.Const.*;

public class NumberValidator {

    public static void validate(String checkNumber){
        checkSize(checkNumber);
    }

    private static void checkSize(String checkNumber) throws IllegalArgumentException {
        if (checkNumber.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
