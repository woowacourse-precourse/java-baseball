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

        throw new IllegalArgumentException("잘못된 값을 입력하였습니다.");
    }

    private static boolean checkCommand(Command command, String input) {
        return command.commandString.equals(input);
    }
}
