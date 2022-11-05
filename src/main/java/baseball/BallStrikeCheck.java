package baseball;

import java.util.List;

public class BallStrikeCheck {
    Number number = new Number();
    int ball = 0;
    int strike = 0;
    private void ballStrikeCount(List computerNumber, String userNumber) {
        for(int i = 0; i<userNumber.length(); i++) {
            if(computerNumber.contains(userNumber.charAt(i)+"") == true && i != computerNumber.indexOf(userNumber.charAt(i)+"")) {
                ball += 1;
            } else if(computerNumber.contains(userNumber.charAt(i)+"") == true && i == computerNumber.indexOf(userNumber.charAt(i)+"")) {
                strike += 1;
            }
        }
    }

    public int ballStrikePrintSet(List computerNumber, String userNumber) {
        ballStrikeCount(computerNumber, userNumber);
        if(ball == 0 && strike == 0) {
            System.out.println("낫싱");
            ball = 0;
            strike = 0;
            return 0;
        } else if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            ball = 0;
            strike = 0;
            return 2;
        } else {
            System.out.printf("%d볼 %d스트라이크\n",ball,strike);
            ball = 0;
            strike = 0;
            return 1;
        }
    }


}
