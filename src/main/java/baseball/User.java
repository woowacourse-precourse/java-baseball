package baseball;

public class User {
    public User() {
    }
    public void getUserGuessInput() {
        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        if(validateUserGuessInput(userInput));
    }

    public boolean validateUserGuessInput(String userInput) {
        int userInt = Integer.parseInt(userInput);
        if(userInt < 0 || userInt > 999) throw new IllegalArgumentException();
        return true;
    }
}
