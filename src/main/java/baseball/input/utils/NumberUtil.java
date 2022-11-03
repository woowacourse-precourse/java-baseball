package baseball.input.utils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberUtil {

    public static List<String> getDigitNumberList(String number) {
        return Stream.of(number.split(""))
                .collect(Collectors.toList());
    }

}
