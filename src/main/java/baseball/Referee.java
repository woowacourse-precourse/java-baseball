package baseball;

import java.util.List;

public class Referee {
    private Computer computer;
    private int strike;
    private int ball;
    private boolean isAnswer;

    public Referee(Computer computer){
        this.computer = computer;
        this.strike = 0;
        this.ball = 0;
        this.isAnswer = false;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isAnswer() {
        return isAnswer;
    }

    public Referee Judge(List<Integer> userNumber){
        List<Integer> computerNumber = computer.getComputerNumber();

        for (int i = 0; i < userNumber.size(); i++){
            if (computerNumber.get(i).equals(userNumber.get(i))){
                this.strike += 1;
            } else if (computerNumber.contains(userNumber.get(i))){
                this.ball += 1;
            }
        }

        if (this.strike == 3){
            isAnswer = true;
        }

        return this;
    }
}
