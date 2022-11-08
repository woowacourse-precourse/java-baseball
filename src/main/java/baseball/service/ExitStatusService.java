package baseball.service;

public class ExitStatusService {
    public static boolean exit(String userInput) throws IllegalArgumentException {
        if (userInput.equals("1"))
            return false;
        else if (userInput.equals("2"))
            return true;

        throw new IllegalArgumentException();
    }
}

