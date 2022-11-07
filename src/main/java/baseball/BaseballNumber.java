package baseball;

import java.util.List;


public class BaseballNumber {
    private List<Integer> number;

    public BaseballNumber() {
    }


    public BaseballNumber(List<Integer> number) {
        validateRangeForAll(number);
        validateDigit(number);
        validateDuplication(number);
        this.number = number;
    }

    public List<Integer> getNumber() {
        return number;
    }

    public void validateRangeForAll(List<Integer> nums) {
        for (int elem : nums) {
            validateRange(elem);
        }
    }

    public void validateRange(int num) {
        if (num > 9 || num < 1) {
            throw new IllegalArgumentException("입력된 숫자가 범위를 초과했습니다.");
        }
    }

    public void validateDigit(List<Integer> nums) {
        if (nums.size() != 3) {
            throw new IllegalArgumentException("세 자리 수가 아닙니다.");
        }
    }

    public void validateDuplication(List<Integer> nums) {
        if (nums.size() != nums.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 수가 있습니다.");
        }
    }




}
