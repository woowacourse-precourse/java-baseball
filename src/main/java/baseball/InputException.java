package baseball;

public class InputException {
    public static boolean checkLength(String number){
        return number.length() == Constant.NUMBER_LENGTH;
    }
}
