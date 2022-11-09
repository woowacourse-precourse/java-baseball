package baseball;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public List<Integer> convertStringToListInteger(String userNumber) {
        List<Integer> numbers = new ArrayList<>();

        for (String s : userNumber.split("")) {
            numbers.add(Integer.parseInt(s));
        }

        return numbers;
    }
}
