package baseball.utility;

public interface Utility {
    public static int DIGIT_LENGTH = 3;
    public static int ONE_ASCII = 49;
    public static int NINE_ASCII = 57;

    public static String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static String END_MESSAGE_1 = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static String END_MESSAGE_2 = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static String INPUT_EXECEPTION_MESSAGE = "잘못된 값을 입력하셨습니다! \n 애플리케이션이 종료됩니다.";

    public static String BALL_MESSAGE = "%d볼";
    public static String STRIKE_MESSAGE = "%d스트라이크";
    public static String NOTHING_MESSAGE = "낫싱";
    
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

    public static void checkRestartAnswerException(String input){
        if(!input.equals("1") && !input.equals("2"))
            throw new IllegalArgumentException(INPUT_EXECEPTION_MESSAGE);
    }
}