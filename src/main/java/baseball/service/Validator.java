package baseball.service;

import baseball.model.Range;

import java.util.List;

public class Validator {

    public void validate(List<Integer> numbers) {

        int maxCount = Range.valueOf("MAX_COUNT").getValue();
        int minValue = Range.valueOf("MIN_VALUE").getValue();
        int maxValue = Range.valueOf("MAX_VALUE").getValue();

        if(numbers.size() < maxCount) {
            throw new IllegalArgumentException("3개 미만의 숫자를 입력할 수 없습니다.");
        }

        if(numbers.size() > maxCount) {
            throw new IllegalArgumentException("3개 초과의 숫자를 입력할 수 없습니다.");
        }

        for(int num : numbers) {
            if (num < minValue || num > maxValue) {
                throw new IllegalArgumentException("1에서 9 사이의 숫자만 입력할 수 있습니다.");
            }
        }

        boolean isDuplicated = numbers.stream()
                .distinct()
                .count() != numbers.size();

        if(isDuplicated) {
            throw new IllegalArgumentException("중복되는 숫자는 입력할 수 없습니다.");
        }
    }
}
