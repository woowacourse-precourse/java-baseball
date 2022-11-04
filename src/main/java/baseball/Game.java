package baseball;

public interface Game {
    default void execute() {
        intro();
        run();
        outro();
    }

    default void replay() {
        run();
        outro();
    }

    void intro();

    void run();

    void outro();
}
