package baseball;

public class Application {
    private static final String QUIT = "2";

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isApplicationRun = true;
        while (isApplicationRun) {
            Game.startGame();
            String input = Game.ResetGameOrQuit();
            isApplicationRun = isAppRun(input);
        }
    }

    private static boolean isAppRun(String input) {
        if (input.equals(QUIT)) {
            return false;
        }
        return true;
    }
}