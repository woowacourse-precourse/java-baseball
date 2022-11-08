package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

    Hitter hitter = new Hitter();
    Pitcher pitcher = new Pitcher();
    Judge judge = new Judge();
    

    private boolean service(boolean stopFlag) {
        System.out.print("숫자를 입력해주세요 ");
        String input = Console.readLine();
        pitcher.setNumber(input);

        int ball = judge.countBall(hitter.getNumber(), pitcher.getNumber());
        int strike = judge.countStrike(hitter.getNumber(), pitcher.getNumber());

        if (ball == 0 && strike == 0) {
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

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String restartInput = Console.readLine();
            if (!restartInput.equals("1") && !restartInput.equals("2")) {
                throw new IllegalArgumentException("올바르지 않은 입력입니다.");
            }
            if (restartInput.equals("1")) {
                hitter.makeNumber();
            }
            if (restartInput.equals("2")) {
                stopFlag = true;
            }
        }
        return stopFlag;
    }
}
