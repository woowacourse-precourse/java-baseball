package baseball.utils;

public class Constants {
    public static final int BASEBALL_GAME_NUMBER_LENGTH = 3;

    public static final int BASEBALL_GAME_NUMBER_RANGE_START = 1;

    public static final int BASEBALL_GAME_NUMBER_RANGE_END = 9;

    public static final String NUMBER_REGEX = "^[1-9]*$";

    public static final int BASEBALL_GAME_RETRY = 1;

    public static final int BASEBALL_GAME_EXIT = 2;

    public static final int[] BASEBALL_GAME_END = {BASEBALL_GAME_RETRY, BASEBALL_GAME_EXIT};
}
