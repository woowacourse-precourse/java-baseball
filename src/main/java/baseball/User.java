package baseball;

import camp.nextstep.edu.missionutils.Console;

import javax.xml.validation.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    private final List<Integer> nums = new ArrayList<>();

    public List<Integer> createNums(List<Integer> inputs, int count) {
        nums.clear();
        for (int i = 0; i < count; i++) {
            Ball ball = new Ball(inputs.get(i));
            if(!nums.contains(ball.getNumber())) {
                nums.add(ball.getNumber());
            }
        }
        validateNums(count);
        return nums;
    }

    private void validateNums(int count) {
        if (nums.size() != count) {
            throw new IllegalArgumentException("중복된 번호가 있습니다.");
        }
    }

    public List<Integer> getInputs() {
        String inputValue = Console.readLine();
        System.out.println("숫자를 입력해주세요 : " + inputValue);
        return Arrays.stream(inputValue.split(""))
                .mapToInt(Integer::valueOf)
                .boxed()
                .collect(Collectors.toList());
    }
}
