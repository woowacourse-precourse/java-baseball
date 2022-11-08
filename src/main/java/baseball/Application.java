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

        // 야구 게임 진행
        while (true) {
            game.initialize();
            choosing(game);  // 숫자 맞추기 진행
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
                correct = true;  // 정답인 경우 숫자유추를 중단
            }
        }
    }
}
