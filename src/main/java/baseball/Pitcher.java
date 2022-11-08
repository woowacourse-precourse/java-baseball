package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Pitcher {

    List<Integer> number;

    public Pitcher() {
    }

    public List<Integer> getNumber() {
        return number;
    }

    public void setNumber(String input) {
        validateInputSize(input);
        validateInputType(input);
        validateInputUnique(input);

        List<Integer> userNumber = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        number = userNumber;
    }

    public void validateInputSize(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력 갯수가 틀립니다.");
        }
    }

    public void validateInputType(String input) {
        List<String> checkNumberList = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");
        Arrays.stream(input.split(""))
                .filter(number -> !checkNumberList.contains(number))
                .forEach(number -> {
                    throw new IllegalArgumentException("올바르지 않은 입력이 있습니다.");
                });
    }

    public void validateInputUnique(String input) {
        Set<String> set = Arrays.stream(input.split(""))
                .collect(Collectors.toSet());
        if (set.size() < 3) {
            throw new IllegalArgumentException("입력중 같은 문자가 있습니다.");
        }
    }

}
