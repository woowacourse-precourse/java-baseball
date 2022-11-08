package baseball;

import java.util.List;

public class BallOrStrike {


    public boolean countStrikeBall(List<Integer> user, List<Integer> computer) {
        int ball = 0;
        int strike = 0;
        for(int userIndex=0; userIndex<user.size(); userIndex++){
            strike += isStrike(computer, user.get(userIndex), userIndex);

            if(ball == 0 ) {
                ball += isBall(computer, user.get(userIndex));
            }
        }

        PrintBallOrStrike print = new PrintBallOrStrike();
        if(strike == 3) {
            print.threeStrike();
            return true;
        } else if( (ball == 0) && (strike == 0)) {
            System.out.println("낫싱");
        } else if((ball != 0) && (strike == 0)){
            print.ball(ball);
        } else if((ball == 0) && (strike != 0)) {
            print.strike(strike);
        } else if ((ball != 0) && (strike != 0)) {
            print.ballAndStrike(ball, strike);
        }

        return false;
    }

    public int isStrike(List<Integer> computer, int userNum, int userIndex) {
        for(int computerIndex=0; computerIndex<computer.size(); computerIndex++) {
            if((userIndex == computerIndex) && (userNum == computer.get(computerIndex))) {
                return 1;
            }
        }

        return 0;
    }

    public int isBall(List<Integer> computer, int userNum) {
        for (Integer computerNum : computer) {
            if (userNum == computerNum) {
                return 1;
            }
        }

        return 0;
    }


}
