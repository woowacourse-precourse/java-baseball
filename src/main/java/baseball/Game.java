package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    public void startGame(GameException gameException) {
        Computer computer = new Computer();

        boolean endPoint = true;

        while (endPoint) {
            System.out.println("숫자를 입력해주세요 : ");
            String inputNum = Console.readLine();

            gameException.inputException(inputNum);

            int strike = computer.countStrike(inputNum);
            int ball = computer.countBall(inputNum, strike);

            endPoint = checkScore(strike, ball);
        }
        endGame(gameException);
    }

    private void endGame(GameException gameException) {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int startOrEnd = Integer.parseInt(Console.readLine());

        gameException.restartException(startOrEnd);

        if (startOrEnd == 1) {
            startGame(gameException);
        }
    }

    private boolean checkScore(int strike, int ball) {
        System.out.println(getScore(strike, ball));

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }

        return true;
    }

    private String getScore(int strike, int ball) {
        StringBuilder sb = new StringBuilder();

        if (ball != 0) {
            sb.append(ball).append("볼");
        }

        if (strike != 0) {
            if (sb.length() != 0) sb.append(" ");

            sb.append(strike).append("스트라이크");
        }

        if (sb.length() == 0) {
            sb.append("낫싱");
        }

        return sb.toString();
    }

}
