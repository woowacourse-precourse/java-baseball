package baseball;

import static baseball.RandomNumberProvider.END;
import static baseball.RandomNumberProvider.MAX_SIZE_OF_LIST;
import static baseball.RandomNumberProvider.START;

import java.util.List;
import java.util.stream.Collectors;


public class RequestController {

    private List<Integer> request;

    RequestController(String request) {
        this.request = request.chars().mapToObj(i -> i - '0')
                .collect(Collectors.toList());
    }

    public List<Integer> validateAndGetIntList() {
        final String errorMsg = "잘못된 입력값 입니다. 중복되지 않는 3자리의 정수를 입력해주세요";

        if (request.size() != MAX_SIZE_OF_LIST
                | isOverlapping()
                | isInvalidRange()) {
            throw new IllegalArgumentException(errorMsg);
        }

        return request;
    }

    private boolean isOverlapping() {
        return request.stream().distinct().count() != request.size();
    }

    private boolean isInvalidRange() {
        return request.stream().anyMatch(i -> END < i | i < START);
    }
}
