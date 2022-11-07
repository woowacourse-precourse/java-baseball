package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Player {

    private List<Integer> number;


    public void setNumber(String input) {
        int num = validateNum(input);
        List<Integer> number = convertInttoList(num);
        BaseballNumber baseballNumber = new BaseballNumber(number);
        this.number = baseballNumber.getNumber();
    }

    public List<Integer> getNumber() {
        return number;
    }
    public int validateNum(String s) {
        try {
            int num = Integer.parseInt(s);
            return num;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 외 문자가 입력되었습니다.");
        }
    }
    public List<Integer> convertInttoList(int num) {
        int[] array = Stream.of(String.valueOf(num)
                        .split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        return Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());
    }
}
