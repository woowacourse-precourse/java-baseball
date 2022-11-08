package baseball.domain.validator;

import baseball.domain.model.request.UserInputRequest;
import java.util.List;
import java.util.stream.Collectors;

public class RequestValidator {

    private static final String INPUT_PATTERN = "^[1-9]{3}$";

    public static void inputValidation(UserInputRequest userInputRequest) {
        List<Character> numbersRequest = userInputRequest.getNumbersRequest();
        if (!isValidPattern(numbersRequest)) {
            throw new IllegalArgumentException("1~9까지의 숫자를 3번 입력해주세요.");
        }
        if (isDuplicated(numbersRequest)) {
            throw new IllegalArgumentException("중복된 숫자를 입력하면 안됩니다.");
        }
    }

    private static boolean isValidPattern(List<Character> numbersRequest) {
        String number = numbersRequest.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        return number.matches(INPUT_PATTERN);
    }

    private static boolean isDuplicated(List<Character> separatedNumbers) {
        int beforeDistinct = separatedNumbers.size();
        long afterDistinct = separatedNumbers.stream()
                .distinct()
                .count();
        return (beforeDistinct != afterDistinct);
    }

}
