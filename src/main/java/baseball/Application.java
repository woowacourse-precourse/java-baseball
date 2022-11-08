package baseball;

public class Application {

    static User user;
    static String OPTION_RESTART = "1";
    static String OPTION_EXIT = "2";
    static String NOTICE_GAMESTART = "숫자 야구 게임을 시작합니다.";
    static String NOTICE_EXITGAME = "종료되었습니다.";

    public static void main(String[] args) {
        System.out.println(NOTICE_GAMESTART);
        String option = OPTION_RESTART;
        user = new User();

        while (option.equals(OPTION_RESTART)) {
            baseballGame();
            user.setInputForOption();
            user.checkInputForOption();
            option = user.input;
            if (option.equals(OPTION_EXIT)) {
                System.out.println(NOTICE_EXITGAME);
            }
        }
    }

    static void baseballGame() {
        Computer computer = new Computer();
        boolean GameOver = false;

        while (!GameOver) {
            user.setInputForAnswer();
            user.checkInputForAnswer();
            String result = computer.getResult(user.input);
            System.out.println(result);
            if (computer.isGameOver(user.input)) {
                GameOver = true;
            }
        }
    }
}
