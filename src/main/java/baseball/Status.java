package baseball;

public enum Status {
    RUNNING(1), EXIT(2);

    private final int option;

    Status(int option) {
        this.option = option;
    }

    public static Status getStatusByOption(int option) {
        if (option == RUNNING.option) {
            return RUNNING;
        }
        return EXIT;
    }
}
