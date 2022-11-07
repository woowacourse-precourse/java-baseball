package baseball;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        int ball;
        int strike;
        int restartOrNot;
        Scanner sc = new Scanner(System.in);
        // 우선 main에서 짜고 분리하는 방식으로 해야겠다 ..
        NumberMaker numberMaker = new NumberMaker();
        String randomNumber;
        String playerNumber;
        System.out.println("숫자 야구 게임을 시작합니다.");
        randomNumber = numberMaker.makeRandomNumber();
        while (true) {
            System.out.println("숫자를 입력해주세요 :");
            playerNumber = numberMaker.makePlayerNumber();
            // 완전히 동일한 경우
            if (randomNumber.equals(numberMaker)) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                restartOrNot = sc.nextInt();
                if (restartOrNot == 1) {
                    randomNumber = numberMaker.makeRandomNumber();
                    continue;
                } else {
                    break;
                }

            } else {
                BallStrikeChecker ballStrikeChecker = new BallStrikeChecker();
                ball = ballStrikeChecker.countBall(randomNumber, playerNumber);
                strike = ballStrikeChecker.countStrike(randomNumber, playerNumber);
                System.out.println(strike + "스트라이크 " + ball + "볼");
            }
        }

    }
}
