package baseball;

import static baseball.RandomNumberProvider.END;
import static baseball.RandomNumberProvider.MAX_SIZE_OF_LIST;
import static baseball.RandomNumberProvider.START;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class RequestController {

    public static List<Integer> validateAndGetIntList(String requestStr) {
        List<Integer> request = toIntList(requestStr);

        if (request.size() != MAX_SIZE_OF_LIST
                | isOverlapping(request)
                | isInvalidRange(request)) {
            throw new IllegalArgumentException(ResponseMsg.NUMBER_INPUT_ERROR_MSG.getMsg());
        }

        return request;
    }

    private static List<Integer> toIntList(String requestStr) {
        return requestStr.chars().mapToObj(i -> i - '0')
                .collect(Collectors.toList());
    }

    private static boolean isOverlapping(List<Integer> request) {
        return request.stream().distinct().count() != request.size();
    }

    private static boolean isInvalidRange(List<Integer> request) {
        return request.stream().anyMatch(i -> END < i | i < START);
    }

    public static int validateNumAndGetOneIfIsOne(String requestStr) {
        final int CH_LENGTH = 1;
        final int ONE = 1;
        final int TWO = 2;
        int result = 0;

        List<Integer> request = toIntList(requestStr);

        if (!Objects.equals(request.size(), CH_LENGTH)
                | request.get(0) < ONE
                | request.get(0) > TWO) {
            throw new IllegalArgumentException(ResponseMsg.GAME_RESTART_OR_STOP_ERROR_MSG.getMsg());
        }

        if (Objects.equals(request.get(0), ONE)) {
            result = ONE;
        }

        return result;
    }

}
