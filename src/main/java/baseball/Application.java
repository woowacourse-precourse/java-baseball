package baseball;

import baseball.utils.InputNumberUtil;
import baseball.utils.RandomNumberGeneratorUtil;

import java.util.List;

import static baseball.constant.BaseballConstant.GAME_FINISH;
import static baseball.constant.BaseballConstant.GAME_START;
import static baseball.constant.BaseballConstant.INPUT_NUMBER;
import static baseball.constant.BaseballConstant.RESTART_GAME;

public class Application {

    public static void main(String[] args) {

        int restart = 1;
        System.out.println(GAME_START);

        do {
            restart = start();
        } while (restart != 2);
    }

    static int start() {
        Game game = new Game();
        int restart = 1;

        List<Integer> computer = RandomNumberGeneratorUtil.makesDifferenceThreeNumber();

        while (true) {
            System.out.print(INPUT_NUMBER);

            String user = InputNumberUtil.inputNumber();

            List<Integer> strikeAndBall = game.findStrikeAndBall(user, computer);

            int strike = strikeAndBall.get(0);
            int ball = strikeAndBall.get(1);

            game.printStrikeAndBall(strike, ball);

            if (game.isCorrectAllNumber(strike)) {
                System.out.println(GAME_FINISH);
                System.out.println(RESTART_GAME);
                restart = game.getRestart();
                break;
            }
        }

        return restart;
    }
}
