package baseball;

public class Application {
    public static void main(String[] args) {
        GameStart gameStart = new GameStart();
        boolean gameNowLooping = true;

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (gameNowLooping) {
            gameNowLooping = gameStart.gameStart();
        }
    }
}