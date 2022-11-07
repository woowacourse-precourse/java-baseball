package baseball.checker;

public final class CommandChecker {

    private static final int COMMAND_LENGTH = 1;
    private static final String RESTART = "1";
    private static final String END = "2";

    private CommandChecker() {
    }

    public static void check(final String command) {
        checkLength(command);
        checkCharacter(command);
    }

    private static void checkLength(final String command) {
        if (command.length() != COMMAND_LENGTH) {
            throw new IllegalArgumentException("재시작 입력의 길이는 1이여야 합니다.");
        }
    }

    private static void checkCharacter(final String command) {
        if (!command.equals(RESTART) && !command.equals(END)) {
            throw new IllegalArgumentException("1과 2를 제외한 명령은 입력할 수 없습니다.");
        }
    }
}
