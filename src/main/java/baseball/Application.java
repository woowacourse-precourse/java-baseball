package baseball;

public class Application {

    private static final String GAME_START_STRING = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_OVER_STRING = "게임 종료";

    public static void main(String[] args) {
        System.out.println(GAME_START_STRING);
        boolean isPlayAgain = true;

        while (isPlayAgain) {
            Game.start();
            isPlayAgain = Game.isPlayAgain();
        }

        System.out.println(GAME_OVER_STRING);
    }
}
