package baseball;


public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            Judge judge = new Judge();
            decideResult(judge);
            if (judge.decideGameContinue() == GameStatus.EXIT.getValue()) {
                break;
            }
        }
    }

    public static void printMessage(int strike, int ball) {
        if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        } else if (strike != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else {
            System.out.println("낫싱");
        }
    }

    public static void decideResult(Judge judge) {
        while (true) {
            Result result = judge.compareBalls(judge.getPlayerNumbers(), judge.getComputerNumbers());
            int strike = result.getStrike();
            int ball = result.getBall();
            printMessage(strike, ball);
            if (strike == GameStatus.STRIKE_OUT.getValue()) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                break;
            }
        }
    }

}

