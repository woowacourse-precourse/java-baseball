package baseball;

import static baseball.RandomNumberProvider.END;
import static baseball.RandomNumberProvider.MAX_SIZE_OF_LIST;
import static baseball.RandomNumberProvider.START;

import java.util.List;
import java.util.stream.Collectors;


public class RequestController {

    public static List<Integer> validateAndGetIntList(String requestStr) {
        List<Integer> request = requestStr.chars().mapToObj(i -> i - '0')
                .collect(Collectors.toList());

        if (request.size() != MAX_SIZE_OF_LIST
                | isOverlapping(request)
                | isInvalidRange(request)) {
            throw new IllegalArgumentException(ResponseMsg.NUMBER_INPUT_ERROR_MSG.getMsg());
        }

        return request;
    }

    private static boolean isOverlapping(List<Integer> request) {
        return request.stream().distinct().count() != request.size();
    }

    private static boolean isInvalidRange(List<Integer> request) {
        return request.stream().anyMatch(i -> END < i | i < START);
    }
}
