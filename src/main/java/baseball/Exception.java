package baseball;

class Exception {
    private static final int RESTART_GAME = 1;
    private static final int STOP_PROGRAM = 2;
    private static final int NUMBER_SIZE = 3;
    private static final int ZERO_IS_NOT_RANGE = 0;

    static void isAllNumeric(String userNumbers) {
        if (!userNumbers.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ResponseMessage.stopExceptionProgram());
        }
    }
}
