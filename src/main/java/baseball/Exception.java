package baseball;

import java.util.List;
import java.util.stream.Collectors;

class Exception {
    private static final int RESTART_GAME = 1;
    private static final int STOP_PROGRAM = 2;
    private static final int NUMBER_SIZE = 3;
    private static final int ZERO_IS_NOT_RANGE = 0;

    static void handleException(List<Integer> user) {
        if (isInvalidLength(user) || isInvalidRange(user) || checkDuplicate(deduplicated(user))) {
            throw new IllegalArgumentException(ResponseMessage.stopExceptionProgram());
        }
    }

    static void isInvalidInput(int gameExecution) {
        if (gameExecution == RESTART_GAME || gameExecution == STOP_PROGRAM) {
            return;
        }
        throw new IllegalArgumentException(ResponseMessage.stopExceptionProgram());
    }

    static void isAllNumeric(String userNumbers) {
        if (!userNumbers.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ResponseMessage.stopExceptionProgram());
        }
    }

    static List<Integer> deduplicated(List<Integer> userNumbers) {
        return userNumbers.stream()
                .distinct().collect(Collectors.toList());
    }

    static boolean isInvalidLength(List<Integer> userNumbers) {
        return userNumbers.size() != NUMBER_SIZE;
    }

    static boolean isInvalidRange(List<Integer> userNumbers) {
        return userNumbers.contains(ZERO_IS_NOT_RANGE);
    }

    static boolean checkDuplicate(List<Integer> deduplicated) {
        return deduplicated.size() != NUMBER_SIZE;
    }
}
