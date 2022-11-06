package baseball.utility;

public interface Utility {
    public static int DIGIT_LENGTH = 3;
    public static int ONE_ASCII = 49;
    public static int NINE_ASCII = 57;

    public static String INPUT_EXECEPTION_MESSAGE = "잘못된 값을 입력하셨습니다! \n 애플리케이션이 종료됩니다.";
    
    public static void checkInputException(String input){
        if(!checkInputLength(input) || !checkInputDigitRange(input) || !checkInputDuplicateCharacters(input))
            throw new IllegalArgumentException(INPUT_EXECEPTION_MESSAGE);
    }
    
    private static boolean checkInputLength(String input){
        return input.length() == DIGIT_LENGTH;
    }

    private static boolean checkInputDigitRange(String input){
        for(int i = 0; i < DIGIT_LENGTH; ++i)
            if(input.charAt(i) < ONE_ASCII && input.charAt(i) > NINE_ASCII)
                return false;
        return true;
    }

    private static boolean checkInputDuplicateCharacters(String input){
        return (input.charAt(0) != input.charAt(1) && input.charAt(0) != input.charAt(2) && input.charAt(1) != input.charAt(2));
    }
}