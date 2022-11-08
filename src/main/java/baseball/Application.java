package baseball;

import baseball.domain.GameResult;
import baseball.game.Computer;
import baseball.game.GameSystem;
import baseball.game.Player;

public class Application {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Player player = new Player();
        GameSystem game = new GameSystem(computer, player);

        while (true) {
            game.initialize();
            choosing(game);  // 야구 숫자맞추기를 진행
            if (!game.continueGame()) {  // 정답을 맞춘 후 한판 더 할건지 확인
                break;
            }
        }
    }

    private static void choosing(GameSystem game) {
        boolean correct = false;
        while (!correct) {  // 정답을 맞출때까지 계속 진행
            GameResult result = game.playGame();
            game.printResult(result);
            if (game.receivedCorrectAnswer(result)) {
                // 정답인 경우
                correct = true;
            }
        }
    }
}
