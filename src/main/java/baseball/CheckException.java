package baseball;

public class CheckException {

    public static boolean restartStatusValue(String restartStatus) {

        return !(restartStatus.equals("1") || restartStatus.equals("2"));
    }

}
