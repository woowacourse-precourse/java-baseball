package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        int restart = 1;
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            restart = start();
        } while (restart != 2);
    }

    static int start() {
        Game game = new Game();
        int restart = 1;

        List<Integer> computer = game.makesDifferenceThreeNumber();

        System.out.println("computer = " + computer);
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");

            String user = Console.readLine();

            List<Integer> strikeAndBall = game.findStrikeAndBall(user, computer);

            int strike = strikeAndBall.get(0);
            int ball = strikeAndBall.get(1);

            game.printStrikeAndBall(strike, ball);

            if (game.isCorrectAllNumber(strike)) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                restart = game.getRestart();
                break;
            }
        }

        return restart;
    }
}
