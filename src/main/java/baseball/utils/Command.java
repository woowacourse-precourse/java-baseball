package baseball.utils;

public enum Command {
    CONTINUE("1"),
    STOP("2");

    private final String commandString;

    Command(String commandString) {
        this.commandString = commandString;
    }

    public static Command of(String input) {
        for (Command command : values()) {
            if (checkCommand(command, input)) {
                return command;
            }
        }

        throw new IllegalArgumentException("올바르지 않은 형식의 재시작 커맨드를 입력하셨습니다.");
    }

    private static boolean checkCommand(Command command, String input) {
        return command.commandString.equals(input);
    }
}
