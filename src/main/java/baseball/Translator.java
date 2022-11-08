package baseball;

import java.util.ArrayList;
import java.util.List;

public class Translator {

    public static List<Integer> translateStringToIntegerList(String input) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            Validator.validateInteger(character);

            list.add(Integer.parseInt(String.valueOf(character)));
        }

        return list;
    }
}
