package baseball;


import static baseball.Application.end;
import static baseball.Constant.MAX_INDEX;
import static baseball.Game.playGame;
import static baseball.Validation.validationCheck;
import static java.lang.Character.getNumericValue;

import java.util.HashMap;
import java.util.Map;


public class Input {


    // 입력 기능
    public static Map<Integer, Integer> inputUserNumber(String userLine) {
        Map<Integer, Integer> userRepository = new HashMap<>();

        if (Integer.valueOf(userLine).equals(1)) {    playGame();    }

        validationCheck(userLine);

        if (Integer.valueOf(userLine).equals(2)) {    end();    }


        for ( int keyIndex = 0; keyIndex < MAX_INDEX; keyIndex++ ) {
            char index = userLine.charAt(keyIndex);
            int valueByKey = getNumericValue(index);
            userRepository.put(keyIndex, valueByKey);
        }


        return userRepository;
    }

}
