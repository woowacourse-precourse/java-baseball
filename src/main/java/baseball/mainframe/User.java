package baseball.mainframe;

public class User {

    private static String userInputValue;
    private static String userRestartInputValue;

    public static void setUserInputValue(String userInput) {
        userInputValue = userInput;
    }

    public static void setUserRestartInputValue(String userRestartInput) {
        userRestartInputValue = userRestartInput;
    }

    public static String getUserInputValue() {
        return userInputValue;
    }

    public static String getUserRestartInputValue() {
        return userRestartInputValue;
    }
}
