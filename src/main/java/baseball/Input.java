package features;


import static extract.Constant.MAX_INDEX;
import static extract.Validation.validationCheck;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.Map;


public class Input {

    private static Map<Integer, Integer> userRepository = new HashMap<>();



    // 입력 기능
    public static Map<Integer, Integer> inputUserNumber(String userLine) {

        userLine = Console.readLine();
        validationCheck(userLine);


        for ( int keyIndex = 0; keyIndex < MAX_INDEX; keyIndex++ ) {
            int valueByKey = parseInt(valueOf(valueOf(userLine).charAt(keyIndex)));
            userRepository.put(keyIndex, valueByKey);
        }


        return userRepository;
    }





}
