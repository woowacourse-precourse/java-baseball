package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    // TODO: <Local Value> Game Class
    private List<Integer> answer;
    private BallCount ballcount;

    public Game(){
        // TODO: <Func> Initializer
        setAnswer();
    }

    // <Func> : Set random answer using pickNumberInRange()
    private void setAnswer(){
        answer = new ArrayList<>();

        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    // <Func> : Get certain answer for testing (Overloading)
    private void setAnswer(List<Integer> answer) {
        this.answer = answer;
    }

    private void checkAnswer(List<Integer> guess){
        // TODO: <Func> Check input value and compare with answer

    }

    // <Func> : Check
    private List<Integer> countUp(){
        // TODO: <Func> Change status
        List<Integer> count = new ArrayList<>();
        return count;
    }

    // <Func> : Print ball count
    private void printCount(){

        if (ballcount.getStrike() == 0 && ballcount.getBall() == 0) {
            System.out.println("낫싱");
        }
        else {
            if (ballcount.getBall() != 0) {
                System.out.print(ballcount.getBall() + "볼");
            }
            if (ballcount.getStrike() != 0) {
                System.out.print(ballcount.getStrike() + "스트라이크 ");
            }
            System.out.println();
        }
    }

    // <Func> : Check game is over and boolean value
    private boolean isOver(){
        // TODO: <Func> Check game is over
        if (ballcount.getStrike() == 3) {
            return true;
        }
        return false;
    }
}
