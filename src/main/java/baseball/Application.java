package baseball;

public class Application {

    public static void main(String[] args) {

        BaseballGame baseballGame = new BaseballGame();

        // TODO: 프로그램 구현
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            baseballGame.startNewGame();
            if (!baseballGame.doesRestart()) {
                break;
            }
        }
    }
}
