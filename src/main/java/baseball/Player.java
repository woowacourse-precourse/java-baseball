package baseball;

public class Player {
    static void checkUserInput(String strIn) {
        UserInputException.lengthCheck(strIn);
        UserInputException.numberCheck(strIn);
        UserInputException.duplicateCheck(strIn);
    }
}
