package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Ball {

    private List <Integer> ball;

    public Ball(){

    }

    public void makeComputerBalls(){
        List<Integer> comBall = new ArrayList<>();
        while (comBall.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comBall.contains(randomNumber)) {
                comBall.add(randomNumber);
            }
        }
        this.ball=comBall;
    }

    public void makeHumanBalls(){
        List<Integer> humanBall = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        while (humanBall.size() < 3) {
            String [] humanInput = Console.readLine().split("");
            if(validate()){
                arrayToList(humanBall, humanInput);
            }
        }
        this.ball = humanBall;
    }

    private void arrayToList(List<Integer> humanBall, String[] humanInput) {
        for(int i = 0; i< humanInput.length; i++){
            humanBall.add(Integer.parseInt(humanInput[i]));
        }
    }


}
