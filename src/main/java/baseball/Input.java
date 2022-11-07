package baseball;


import static baseball.Constant.MAX_INDEX;
import static baseball.Validation.validationCheck;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

import java.util.HashMap;
import java.util.Map;


public class Input {


    // 입력 기능
    public static Map<Integer, Integer> inputUserNumber(String userLine) {
        Map<Integer, Integer> userRepository = new HashMap<>();

        validationCheck(userLine);


        for ( int keyIndex = 0; keyIndex < MAX_INDEX; keyIndex++ ) {
            int valueByKey = parseInt(valueOf(valueOf(userLine).charAt(keyIndex)));
            userRepository.put(keyIndex, valueByKey);
        }

        return userRepository;
    }

}
