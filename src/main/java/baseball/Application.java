package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameContext gameContext = new GameContext();
        gameContext.initializeContext();

        System.out.println("숫자 야구 게임을 시작합니다.");

        while(!gameContext.gameShouldStop()) {

            switch (gameContext.getState()) {
                case RUNNING:
                    System.out.print("숫자를 입력해주세요 : ");
                    gameContext.handleUserInput();
                    break;
                case REPLAY:
                    gameContext.initializeContext();
                    break;
                case THREE_STRIKE:
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    gameContext.handleUserInput();
                    break;
            }

        }

        System.out.println("게임 종료.");

    }
}
