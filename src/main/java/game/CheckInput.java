package game;

public class CheckInput {
    public boolean checkInput(String userInput) throws IllegalArgumentException {
        if (userInput.equals("1") || userInput.equals("2")) {
            return true;
        }
        throw new IllegalArgumentException();
    }
}
