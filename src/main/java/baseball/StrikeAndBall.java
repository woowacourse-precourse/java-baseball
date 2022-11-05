package baseball;

import java.util.List;

public class StrikeAndBall {
    int strike, ball;

    StrikeAndBall(){
        strike = 0;
        ball = 0;
    }

    private void addStrike(){
        this.strike++;
    }

    private void addBall(){
        this.ball++;
    }

    public GameMassage getResult(){
        if(isNothing()){
            return GameMassage.NOTHING;
        }
        else if(isAllStrike()){
            return GameMassage.ALL_STRIKE;
        }
        else{
            String ballAndStrike = GameMassage.NOT_ANSWER.getMassage();
            ballAndStrike = String.format(ballAndStrike, ball, strike);
            GameMassage.NOT_ANSWER.setMassage(ballAndStrike);
            return GameMassage.NOT_ANSWER;
        }
    }

    private boolean isNothing(){
        return (this.strike == 0 && this.ball == 0);
    }

    private boolean isAllStrike(){
        return  (this.strike == 3);
    }


    private void isContain(int userDigit, List<Integer> computer){
        if (computer.contains(userDigit)) {
            addBall();
        }
    }

    private void isSame(int computerDigit, int userDigit, List<Integer> computer){
        if (computerDigit == userDigit) {
            addStrike();
        } else {
            isContain(userDigit, computer);
        }
    }

    public void compareDigits(List<Integer> computer, List<Integer> user){
        for (int i = 0; i < user.size(); i++) {
            isSame(computer.get(i), user.get(i), computer);
        }
    }
}
