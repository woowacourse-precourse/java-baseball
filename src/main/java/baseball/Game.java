package baseball;

import java.util.List;

public class Game {

    private int ball;
    private int strike;


    public void play() {
        do {
            List<Integer> computerBallsList = Computer.makeBalls();
            play2(computerBallsList);
        } while (User.wantRegame());
    }


    public void play2(List<Integer> computerBallsList){
        do {
            ball = 0;
            strike = 0;

            List<Integer> userBallsList = User.inputBalls();
            compareComputerAndUser(computerBallsList, userBallsList);
            System.out.println(printResult());
        } while(strike<3);
    }


    private void compareComputerAndUser(List<Integer> computerBallsList, List<Integer> userBallsList) {
        for (int i = 0; i < computerBallsList.size(); i++) {
            if (userBallsList.contains(computerBallsList.get(i))) {
                ball++;
            }
            if (computerBallsList.get(i) == userBallsList.get(i)) {
                strike++;
            }
        }
        ball -= strike;
    }


    private String printResult() {

        if (ball == 0 && strike == 0) {
            return "낫싱";
        }
        if (strike == Computer.BallsLength) {
            return strike + "스트라이크\n" + Computer.BallsLength + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        if (strike == 0) {
            return ball + "볼";
        }

        return ball + "볼 " + strike + "스트라이크";

    }

}
