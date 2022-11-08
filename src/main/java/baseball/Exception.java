package baseball;

import java.util.HashSet;
import java.util.Set;

public class Exception {



    public void checkLength(String userBaseBallNumber) throws IllegalArgumentException {
        if (userBaseBallNumber.length() != 3) {
            throw new IllegalArgumentException();
        }
    }



}
