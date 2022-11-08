package baseball;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("숫자 야구 게임을 시작합니다.");
            Game game = new Game();
            boolean restart = true;
            while (restart) {
                boolean isThreeStrike = false;
                game.computerSelectThreeNumbers();
                while (!isThreeStrike) {
                    game.initializeBallCount();
                    game.userSelectThreeNumbers();
                    game.countMatchingNumbers();
                    isThreeStrike = game.printResultOfGame();
                }
                restart = game.decideRestartOrQuit();
            }
            System.out.println("애플리케이션을 종료합니다.");
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println("애플리케이션을 종료합니다.");
        }
    }
}
