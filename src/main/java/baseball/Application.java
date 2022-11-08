package baseball;

public class Application {
    public static void main(String[] args) {
        BaseballOutput.printGameStart();
        Baseball baseball = new Baseball();
        do {
            baseball.play();
        } while (does_user_want_play_again());
    }

    public static boolean does_user_want_play_again() {
        Integer play_code = BaseballInput.getPlayCode();
        return play_code.equals(PlayCode.PLAY_AGAIN.getCode());
    }
}
