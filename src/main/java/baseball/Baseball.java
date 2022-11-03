package baseball;

public class Baseball {
    private BaseballInput baseballInput;
    private BaseballOutput baseballOutput;
    private BaseballResult baseballResult;
    private BaseballScore baseballScore;

    public static int EXIT_CODE = 2;
    public static int PLAY_AGAIN_CODE = 1;


    Baseball() {
        baseballInput = new BaseballInput();
        baseballOutput = new BaseballOutput();
        baseballResult = new BaseballResult();
        baseballScore = new BaseballScore();
    }

    public void play() {
        baseballOutput.printGameStart();
        do {

        } while (does_user_want_play_again());

    }

    private boolean does_user_want_play_again() {
        Integer play_code = get_user_input_play_code();
        return play_code.equals(PLAY_AGAIN_CODE);
    }

    private Integer get_user_input_play_code() {

        Integer play_code = null;

        while (play_code == null || !(play_code == PLAY_AGAIN_CODE || play_code == EXIT_CODE)) {

            try {
                baseballOutput.printInputPlayCodeMessage();
                play_code = Integer.parseInt(baseballInput.getUserInput());

            } catch (NumberFormatException e) {

            }
        }
        return play_code;
    }
}
