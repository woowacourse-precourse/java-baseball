package baseball;

import java.util.ArrayList;

public class PlayerInputValueExceptions {

    static void isThreeDigits(ArrayList<String> userSelectedNumbers) {
        if (userSelectedNumbers.size() != 3) {
            throw new IllegalArgumentException("3자리만 입력하세요");
        }
    }
}
