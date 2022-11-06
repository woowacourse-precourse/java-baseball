package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {

    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    public static final String WRONG_FORMAT_NUMBER = "잘못된 숫자 입력입니다.";
    public static final String GAME_FINISH = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESTART_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


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

        List<Integer> computer = game.makesDifferenceThreeNumber();

        while (true) {
            System.out.print(INPUT_NUMBER);

            String user = Console.readLine();

            if (!game.isCorrectInput(user)) {
                throw new IllegalArgumentException(WRONG_FORMAT_NUMBER);
            }

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
