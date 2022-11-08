package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    Hitter hitter = new Hitter();
    Pitcher pitcher = new Pitcher();
    Referee referee = new Referee();

    public void start() {
        boolean stopFlag = false;

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (!stopFlag) {
            stopFlag = gameService(stopFlag);
        }
    }

    private boolean gameService(boolean stopFlag) {
        System.out.print("숫자를 입력해주세요 ");
        String input = Console.readLine();
        pitcher.setNumber(input);

        int ball = referee.countBall(hitter.getNumber(), pitcher.getNumber());
        int strike = referee.countStrike(hitter.getNumber(), pitcher.getNumber());

        if (referee.isNothing(ball, strike)) {
            System.out.println("낫싱");
            return false;
        }
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크 ");
        }
        System.out.println();

        if (strike == Constants.NUMBER_LENGTH) {
            System.out.println(Constants.NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 " + Constants.GAME_RESTART_NUMBER + ", 종료하려면 " + Constants.GAME_END_NUMBER
                    + "를 입력하세요.");

            String restartInput = Console.readLine();
            stopFlag = askGameStop(stopFlag, restartInput);
        }
        return stopFlag;
    }

    private boolean askGameStop(boolean stopFlag, String restartInput) {
        if (!restartInput.equals(Constants.GAME_RESTART_NUMBER) && !restartInput.equals(
                Constants.GAME_END_NUMBER)) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }
        if (restartInput.equals(Constants.GAME_RESTART_NUMBER)) {
            hitter.makeNumber();
        }
        if (restartInput.equals(Constants.GAME_END_NUMBER)) {
            stopFlag = true;
        }
        return stopFlag;
    }
}
