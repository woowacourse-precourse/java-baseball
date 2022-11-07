package baseball.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SystemUserModel {
    private List<Integer> digits;

    public SystemUserModel() {
    }

    public Integer getDigit(int index) {
        return digits.get(index);
    }

    public void setDigits(String input) {
        this.digits = Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
