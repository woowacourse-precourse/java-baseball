package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameContext gameContext = new GameContext();
        gameContext.initializeContext();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(!gameContext.gameShouldStop())
            gameContext.run();

        System.out.println("게임 종료.");

    }
}
