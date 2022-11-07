package baseball.logic;

public class RestartValidation {
    public static boolean checkRestart(String restartinput) {
        return restartinput.equals("1") || restartinput.equals("2");
    }
}
