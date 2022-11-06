package baseball;

public class View {
    public static String GAME_START_MASSAGE = "숫자를 입력해주세요:";
    public static String GAME_RESTART_ERROR_MASSAGE = "1과 2만 입력할 수 있습니다.";
    public static String INPUT_IS_NOT_DIGIT_MASSAGE = "숫자만 입력해주세요.";
    public static String INPUT_IS_ZERO_MASSAGE = "1과 9사이의 숫자만 입력해주세요.";
    public static String INPUT_LENGTH_VALIDATION_MASSAGE = "입력은 세자리 숫자만 허용됩니다.";
    public static String THREE_STRIKE_MASSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static String GAME_END_OR_RESTART_MASSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static String GAME_END_MASSAGE = "게임을 종료합니다.";


    public static String GAME_RESTART = "1";
    public static String GAME_END = "2";
    public static int MAX_BALL_LENGTH = 3;
    public static char WRONG_USER_INPUT_ZERO = '0';
    public static int MIN_INPUT_NUMBER = 1;
    public static int MAX_INPUT_NUMBER = 9;

    public static void showGameStartMassage() {
        System.out.println(GAME_START_MASSAGE);
    }

    public static void showThreeStrikeMassage() {
        System.out.println(THREE_STRIKE_MASSAGE);
    }

    public static void showGameEndOrRestartMassage() {
        System.out.println(GAME_END_OR_RESTART_MASSAGE);
    }

    public static void showGameEndMassage() {
        System.out.println(GAME_END_MASSAGE);
    }

    public static void showGameRestartErrorMassage() {
        System.out.println(GAME_RESTART_ERROR_MASSAGE);
    }



    public static void raiseErrorWhenInputIsNotDigitOrZero(char separatedInput) {
        if (!Character.isDigit(separatedInput)) {
            throw new IllegalArgumentException(INPUT_IS_NOT_DIGIT_MASSAGE);
        }
        if (separatedInput == WRONG_USER_INPUT_ZERO) {
            throw new IllegalArgumentException(INPUT_IS_ZERO_MASSAGE);
        }
    }

    public static void raiseErrorWhenInputLengthOverThree(String userInput) {
        if (userInput.length() > MAX_BALL_LENGTH) {
            throw new IllegalArgumentException(INPUT_LENGTH_VALIDATION_MASSAGE);
        }
    }

    public static void raiseErrorWhenInputIsNotOneOrTwo(String userInput) {
        try {
            if (!(userInput.equals(GAME_RESTART) || userInput.equals(GAME_END))) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            showGameRestartErrorMassage();
            raiseErrorWhenInputIsNotOneOrTwo(userInput);
        }
    }

}
